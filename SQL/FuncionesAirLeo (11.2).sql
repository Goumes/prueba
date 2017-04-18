USE AirLeo

GO

/* 1. Escribe un procedimiento que cancele un pasaje y las tarjetas de embarque asociadas. 
Recibir� como par�metros el ID del pasaje. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE CancelarPasajeEmbarque (@IDPasaje INT)
AS
	BEGIN

	select * from AL_Tarjetas where Numero_Pasaje = 0


		BEGIN TRANSACTION

		DELETE FROM AL_Tarjetas WHERE Numero_Pasaje = @IDPasaje

		--ROLLBACK
		COMMIT TRANSACTION


		BEGIN TRANSACTION
		DELETE FROM AL_Pasajes WHERE Numero = @IDPasaje

		--ROLLBACK
		COMMIT TRANSACTION

	END

GO

--ROLLBACK
COMMIT TRANSACTION

-- NO EJECUTAR


/* 2. Escribe un procedimiento almacenado que reciba como par�metro el ID de un pasajero y devuelva en un par�metro 
de salida el n�mero de vuelos diferentes que ha tomado ese pasajero. */

BEGIN TRANSACTION

GO

CREATE PROCEDURE NumeroVuelos 
	@IDPasajero CHAR (9),
	@NumeroVuelosDiferentes INT OUTPUT
AS
	BEGIN
		SELECT DISTINCT COUNT (Codigo_Vuelo)
			FROM AL_Pasajeros AS P
			INNER JOIN
			AL_Pasajes AS Pa
			ON P.ID = Pa.ID_Pasajero
			INNER JOIN
			AL_Vuelos_Pasajes AS VP
			ON Pa.Numero = VP.Numero_Pasaje
			WHERE P.ID = @IDPasajero

		RETURN
	END
GO

ROLLBACK
COMMIT TRANSACTION

DECLARE @NumeroVuelosDiferentesResultados INT
EXECUTE NumeroVuelos 'A003', @NumeroVuelosDiferentes = @NumeroVuelosDiferentesResultados OUTPUT

/* 3. Escribe un procedimiento almacenado que reciba como par�metro el ID de un pasajero y dos fechas y nos 
devuelva en otro par�metro (de salida) el n�mero de horas que ese pasajero ha volado durante ese intervalo de fechas.*/

BEGIN TRANSACTION

GO

CREATE PROCEDURE TiempoVolado
	@IDPasajero CHAR (9),
	@FechaInicial SMALLDATETIME,
	@FechaFinal SMALLDATETIME,
	@TiempoEnVuelo DECIMAL (5,2) OUTPUT

	AS

	BEGIN
		SELECT SUM (DATEPART (HOUR, (Llegada - Salida)))
			FROM AL_Vuelos AS V
			INNER JOIN
			AL_Vuelos_Pasajes AS VP
			ON V.Codigo = VP.Codigo_Vuelo
			INNER JOIN
			AL_Pasajes AS P
			ON VP.Numero_Pasaje = P.Numero
			WHERE P.ID_Pasajero = @IDPasajero AND (Salida BETWEEN @FechaInicial AND @FechaFinal) AND (Llegada BETWEEN @FechaInicial AND @FechaFinal)

		RETURN
	END

ROLLBACK

COMMIT TRANSACTION

DECLARE @TiempoEnVueloResultado DECIMAL (5,2)
EXECUTE TiempoVolado 'A003', '01/01/2013 12:30', '01/12/2014 12:30', @TiempoEnVuelo = @TiempoEnVueloResultado OUTPUT

/* 4. Escribe un procedimiento que reciba como par�metro todos los datos de un pasajero y un n�mero de vuelo y realice el siguiente proceso:
En primer lugar, comprobar� si existe el pasajero. Si no es as�, lo dar� de alta. A continuaci�n comprobar� si el vuelo 
tiene plazas disponibles (hay que consultar la capacidad del avi�n) y en caso afirmativo crear� un nuevo pasaje para ese vuelo.*/

BEGIN TRANSACTION

GO

CREATE PROCEDURE RegistrarVuelo
	@ID CHAR (9),
	@Nombre VARCHAR (20),
	@Apellidos VARCHAR (50),
	@Direccion VARCHAR (60),
	@Fecha_Nacimiento DATE,
	@Nacionalidad VARCHAR (30),
	@Codigo_Vuelo INT

	AS

	IF NOT EXISTS  (SELECT *
					FROM AL_Pasajeros
					WHERE ID = @ID)

		BEGIN TRANSACTION

		BEGIN

			INSERT INTO AL_Pasajeros (ID, Nombre, Apellidos, Direccion, Fecha_Nacimiento, Nacionalidad)
			VALUES
					(@ID, @Nombre, @Apellidos, @Direccion, @Fecha_Nacimiento, @Nacionalidad, @Codigo_Vuelo)
		END

		COMMIT TRANSACTION

	/* La capacidad del avi�n es el numero de asientos_x_fila * filas. Si el numero de pasajes vendidos en un vuelo es menor al resultado
	del calculo de la capacidad del avi�n, significa que hay plazas libres. */
	DECLARE @Capacidad INT
	SELECT @Capacidad = Asientos_x_Fila * Filas
		FROM AL_Aviones AS A
		INNER JOIN
		AL_Vuelos AS V
		ON A.Matricula = V.Matricula_Avion
		WHERE V.Codigo = @Codigo_Vuelo

ROLLBACK
COMMIT TRANSACTION