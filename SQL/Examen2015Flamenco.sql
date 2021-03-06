USE Flamenco

GO

/* Tenemos una base de datos sobre cantaores flamencos. Los artistas cantan diferentes
�palos�. Un mismo palo puede ser cantado por diferentes cantaores.
Tambi�n registramos pe�as flamencas, que est�n repartidas por diferentes localidades. Los
artistas act�an en las pe�as.
Las pe�as organizan festivales con periodicidad anual. En esos festivales act�an los artistas. */

/* Ejercicio 1
N�mero de veces que ha actuado cada cantaor en cada festival de la provincia de C�diz,
incluyendo a los que no han actuado nunca */

SELECT * FROM F_Festivales
/* Ejercicio 2
Crea un nuevo palo llamado �Ton�.
Haz que todos los cantaores que cantaban Bamberas o Peteneras canten Ton�s. No utilices
los c�digos de los palos, sino sus nombres. */



/* Ejercicio 3
N�mero de cantaores mayores de 30 a�os que han actuado cada a�o en cada pe�a. Se
contar� la edad que ten�an en el a�o de la actuaci�n. */



/* Ejercicio 4
Cantaores (nombre, apellidos y nombre art�stico) que hayan actuado m�s de dos veces en
pe�as de la provincia de Sevilla y canten Fandangos o Buler�as. S�lo se incluyen las
actuaciones directas en Pe�as, no los festivales. */



/* Ejercicio 5
N�mero de actuaciones que se han celebrado en cada pe�a, incluyendo actuaciones directas
y en festivales. Incluye el nombre de la pe�a y la localidad. */