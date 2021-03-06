package Main;

import Clases.*;
import Gestoras.GestoraAleatoria;
import Gestoras.GestoraJuego;

import java.util.*;
import java.io.*;

/* Nombre del programa: MainJuego
 * Breve comentario: Juego roge-like y con combate por turnos
 * Entradas: 
 * Salidas: 
 * Restricciones: Ninguna
 * 
 * OBLIGATORIO HACERLO CON FICHEROS Y CON BADAT.
 * 
 * PG.
 * Inicio
 * 	LeerValidarJugar
 * 	Mientras QuieraJugar
 * 		LeerPartidas *
 * 		PrintElegirBorrarPartidas *
 *		EjecutarJuego
 *		Preguntar JugarOtraVez
 * 	Fin_Mientras QuieraJugar        
 * Fin
 * 
 * Modulo EjecutarJuego Nivel 1
 * Inicio
 * 	si Partida no creada
 *		GenerarMazmorra *
 *		CrearPersonaje *
 *		GuardarPartida *
 * 	fin_si
 * 	Jugar
 * 	GuardarPartida *
 * 	PrintEstadoPartida *
 * Fin
 * 
 * Modulo EligePartida Nivel 1
 * Inicio
 * 	PrintPartidasDisponibles *
 * 	LeerValidarElegirPartida *
 * Fin
 * 
 * Modulo Jugar Nivel 1
 * Inicio
 * 	PrintMenuLeerValidarAcciones
 * 	Mientras Accion != 0
 * 		Segun (accion)
 * 			Caso 1: Abrir cofre
 * 			Caso 2: Ir tienda
 * 			Caso 3: Pelear
 * 			Caso 4: Avanzar
 * 			Caso 5: Abrir Inventario
 * 			Caso 6: Ver mapa
 * 		Fin_segun
 *		PrintMenuLeerValidarAcciones
 * 	Fin_Mientras
 * Fin
 */

public class MainJuego 
{
	/* Prototipo: void printPartidas (Partida partida1, Partida partida2, Partida partida3)
	 * Breve comentario: Subprograma dedicado
	 * Precondiciones: Ninguna
	 * Entradas: Tres partidas
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void printPartidas (Partida partida1, Partida partida2, Partida partida3)
		{
			System.out.println("Llamada al metodo printPartidas");
		}
	 */
	public static void printPartidas (Partida partida1, Partida partida2, Partida partida3)
	{
		System.out.println("Selecciona una partida:");
		System.out.println();
		
		if (partida1.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
		{
			System.out.println("Partida 1: Crear nueva partida");
			System.out.println();
		}
		
		else
		{
			System.out.println("Partida 1: ");
			System.out.println();
			partida1.imprimirJugador ();
		}
		
		if (partida2.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
		{
			System.out.println("Partida 2: Crear nueva partida");
			System.out.println();
		}
		
		else
		{
			System.out.println("Partida 2: ");
			System.out.println();
			partida2.imprimirJugador();
		}
		
		if (partida3.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
		{
			System.out.println("Partida 3: Crear nueva partida");
			System.out.println();
		}
		
		else
		{
			System.out.println("Partida 3: ");
			System.out.println();
			partida3.imprimirJugador ();
		}
		
		System.out.println("0. Borrar una partida");
	}
	//Fin printPartidas
	
	/* Prototipo: void menuAcciones ()
	 * Breve comentario: Menu de acciones del programa.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuAcciones ()
		{
			System.out.println("Llamada al metodo menuAcciones");
		}
	 */
	public static void menuAcciones ()
	{
		System.out.println();
		System.out.println("Esta es tu interfaz de acciones. Selecciona una opci�n.");
		System.out.println();
		System.out.println("1. Abrir cofre");
		System.out.println("2. Ir a tienda");
		System.out.println("3. Pelear");
		System.out.println("4. Avanzar");
		System.out.println("5. Abrir inventario");
		System.out.println("6. Ver mapa");
		System.out.println("0. Guardar y salir");
		System.out.println();
	}
	//Fin menuAcciones
	
	/* Prototipo: void menuMovimiento ()
	 * Breve comentario: Menu de movimiento del programa.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuMovimiento ()
		{
			System.out.println("Llamada al metodo menuMovimiento");
		}
	 */
	public static void menuMovimiento ()
	{
		System.out.println();
		System.out.println("�Hacia qu� direcci�n quieres moverte?");
		System.out.println();
		System.out.println("1. Arriba");
		System.out.println("2. Derecha");
		System.out.println("3. Abajo");
		System.out.println("4. Izquierda");
		System.out.println("0. Salir");
		System.out.println();
	}
	//Fin menuMovimiento
	
	/* Prototipo: void menuBorrar ()
	 * Breve comentario: Menu de movimiento del programa.
	 * Precondiciones: Ninguna
	 * Entradas: Ninguna
	 * Salidas: Ninguna
	 * Entradas/Salidas: Ninguna
	 * Postcondiciones: Ninguna
	 * 
	 * Resguardo: public void menuBorrar ()
		{
			System.out.println("Llamada al metodo menuBorrar");
		}
	 */
	public static void menuBorrar ()
	{
		System.out.println();
		System.out.println("�Qu� partida deseas borrar?");
		System.out.println();
		System.out.println("1. Partida 1");
		System.out.println("2. Partida 2");
		System.out.println("3. Partida 3");
		System.out.println("0. Ninguna");
		System.out.println();
	}
	//Fin menuBorrar
	
	public static void main (String [] args)
	{
		Scanner teclado = new Scanner (System.in);
		char ejecutar = ' ';
		int numeroPartida = 0;
		Partida partida1 = new Partida ();
		Partida partida2 = new Partida ();
		Partida partida3 = new Partida ();
		Partida partidaDefinitiva = null;
		GestoraJuego gestora = new GestoraJuego ();
		GestoraAleatoria gestoraAleatoria = new GestoraAleatoria ();
		int accion = 0;
		int eleccionInventario = 0;
		int eleccionTienda = 0;
		int eleccionCombate = 0;
		int numeroInventario = -1;
		char utilizar = ' ';
		char comprar = ' ';
		boolean resultadoInventario = false;
		int posicion = 0;
		int borrar = 0;
		char avanzar = ' ';
		boolean muerto = false;
		
		//LeerValidarJugar
		do
		{
			System.out.println("Quieres jugar a EstoNoTieneNadaQueVerConIsaac? S/N");
			ejecutar = Character.toLowerCase(teclado.next().charAt(0));

		}
		while (ejecutar != 's' && ejecutar != 'n');
		//Fin LeerValidarJugar
		
		while (ejecutar == 's')
		{
			
			
			while (partidaDefinitiva == null)
			{
				
				//LeerPartidas
				partida1 = gestora.leerPartida (1);
				partida2 = gestora.leerPartida (2);
				partida3 = gestora.leerPartida (3);
				//Fin LeerPartidas
				
				//PrintElegirBorrarPartidas
				do
				{
					try
					{
						MainJuego.printPartidas (partida1, partida2, partida3);
						numeroPartida = teclado.nextInt();
					}
					catch (InputMismatchException e)
					{
						numeroPartida = -1;
						System.out.println();
						System.out.println("Ja ja que gracioso.");
						System.out.println();
						teclado.next();
					}
				}
				while (numeroPartida < 0 || numeroPartida > 3);
				
				if (numeroPartida != 0)
				{
					partidaDefinitiva = gestora.asignarPartida (partida1, partida2, partida3, numeroPartida);
				}
				
				else
				{
					do
					{
						try
						{
							menuBorrar ();
							borrar = teclado.nextInt();
						}
						catch (InputMismatchException e)
						{
							borrar = -1;
							System.out.println();
							System.out.println("Ja ja que gracioso.");
							System.out.println();
							teclado.next();
						}
					}
					while (borrar < 0 || borrar > 3);
					
					gestora.borrarPartida (borrar);
				}
			}//Fin mientras
			
			//Fin PrintElegirBorrarPartidas
		
			//EjecutarJuego
			
				//si Partida no creada
				if (partidaDefinitiva.equals(new Partida (new Mazmorra (), new JugadorIMPL ())))
				{
				
					//GenerarMazmorra *
					partidaDefinitiva.setMazmorra(gestoraAleatoria.generarMazmorraAleatoria ());
					//Fin GenerarMazmorra
					
					//CrearPersonaje *
					partidaDefinitiva.setJugador(gestora.crearJugador());
					//Fin CrearPersonaje
					
					//GuardarPartida *
					gestora.guardarPartida(partidaDefinitiva.getMazmorra (), partidaDefinitiva.getJugador (), numeroPartida);
					//Fin GuardarPartida
				
				}//fin_si
				
				//Jugar 
				
				// PrintMenuLeerValidarAcciones
				do
				{
					try
					{
						menuAcciones ();
						accion = teclado.nextInt();
					}
					catch (InputMismatchException e)
					{
						accion = -1;
						System.out.println();
						System.out.println("Ja ja que gracioso.");
						System.out.println();
						teclado.next();
					}
				}
				while (accion < 0 || accion > 6);
				//Fin PrintMenuLeerValidarAcciones
				
				while (accion != 0)
				{
				
					switch (accion)
					{

						//Abrir Cofre
						case 1:
							gestora.abrirCofre (partidaDefinitiva);
						break;

						//Ir a Tienda
						case 2:
							if (gestora.comprobarTienda (partidaDefinitiva.getMazmorra()))
							{
								//LeerValidarEleccionTienda
								do
								{
									try
									{
										gestora.abrirTienda(partidaDefinitiva);
										eleccionTienda = teclado.nextInt();
									}
									catch (InputMismatchException e)
									{
										eleccionTienda = -1;
										System.out.println();
										System.out.println("Ja ja que gracioso.");
										System.out.println();
										teclado.next();
									}
								}
								while (eleccionTienda < 0 || eleccionTienda > 4);
								//Fin LeerValidarEleccionTienda
								
								while (eleccionTienda != 0)
								{
									//LeerValidarComprar
									do
									{
										System.out.println();
										System.out.println("�Quieres comprar este objeto?");
										System.out.println();
										comprar = Character.toLowerCase(teclado.next().charAt(0));
									}
									while (comprar != 's' && comprar != 'n');
									//LeerValidarComprar
									
									if (comprar == 's')
									{
										if (gestora.elegirItemTienda(partidaDefinitiva, eleccionTienda))
										{
											System.out.println();
											System.out.println("Has comprado el objeto y se ha a�adido a tu inventario!");
											System.out.println();
										}
										
										else
										{
											System.out.println();
											System.out.println("No tienes dinero suficiente para comprar este objeto");
											System.out.println();
										}
									}
									//LeerValidarEleccionTienda
									do
									{
										try
										{
											gestora.abrirTienda(partidaDefinitiva);
											eleccionTienda = teclado.nextInt();
										}
										catch (InputMismatchException e)
										{
											eleccionTienda = -1;
											System.out.println();
											System.out.println("Ja ja que gracioso.");
											System.out.println();
											teclado.next();
										}
									}
									while (eleccionTienda < 0 || eleccionTienda > 4);
									//Fin LeerValidarEleccionTienda
								}
							}
							
							else
							{
								System.out.println();
								System.out.println("Quiz�s deber�as buscar una tienda antes de intentar comprar...");
								System.out.println();
							}
						break;
						
						//Pelear enemigo
						case 3:
							
							if (gestora.comprobarEnemigo(partidaDefinitiva.getMazmorra()))
							{
								//LeerValidarEleccionCombate
								do
								{
									try
									{
										gestora.interfazCombate(partidaDefinitiva);
										eleccionCombate = teclado.nextInt();
									}
									catch (InputMismatchException e)
									{
										eleccionCombate = -1;
										System.out.println();
										System.out.println("Ja ja que gracioso.");
										System.out.println();
										teclado.next();
									}
								}
								while (eleccionCombate < 0 || eleccionCombate > 2);
								//Fin LeerValidarEleccionCombate
								
								while (eleccionCombate != 0)
								{
									switch (eleccionCombate)
									{
									
									//Combatir
									case 1:
										gestora.combate(partidaDefinitiva);
										
										if (partidaDefinitiva.getJugador().getVida() == 0)
										{
											System.out.println("Has muerto...");
											System.out.println();
											System.out.println("Este juego tiene derechos de copyright de Tera y de Jaranator-3000. Gracias por jugar.");
											System.out.println();
											gestora.borrarPartida(numeroPartida);
											muerto = true;
											
										}
										
									break;
										
									//UtilizarItem
									case 2:
										
										//LeerValidarEleccionInventario
										do
										{
											try
											{
												numeroInventario = gestora.monstrarInventario(partidaDefinitiva.getJugador());
												eleccionInventario = teclado.nextInt();
											}
											catch (InputMismatchException e)
											{
												eleccionInventario = -1;
												System.out.println();
												System.out.println("Ja ja que gracioso.");
												System.out.println();
												teclado.next();
											}
										}
										while (eleccionInventario < 0 || eleccionInventario > numeroInventario);
										//Fin LeerValidarEleccionInventario
										
										while (eleccionInventario != 0)
										{
											//LeerValidarUtilizarItem
											do
											{
												System.out.println();
												System.out.println("�Quieres utilizar este objeto?");
												System.out.println();
												utilizar = Character.toLowerCase(teclado.next().charAt(0));
											}
											while (utilizar != 's' && utilizar != 'n');
											//Fin LeerValidarUtilizarItem
											
											if (utilizar == 's')
											{
												resultadoInventario = gestora.utilizarItem (partidaDefinitiva.getJugador(), eleccionInventario);
												
												if (resultadoInventario)
												{
													System.out.println();
													System.out.println("Haz utilizado el item con �xito!");
													System.out.println();
												}
												
												else
												{
													System.out.println();
													System.out.println("No puedes utilizar una poci�n de efecto temporal fuera de combate!");
													System.out.println();
												}
											}
											
											//LeerValidarEleccionInventario
											do
											{
												try
												{
													numeroInventario = gestora.monstrarInventario(partidaDefinitiva.getJugador());
													eleccionInventario = teclado.nextInt();
												}
												catch (InputMismatchException e)
												{
													eleccionInventario = -1;
													System.out.println();
													System.out.println("Ja ja que gracioso.");
													System.out.println();
													teclado.next();
												}
											}
											while (eleccionInventario < 0 || eleccionInventario > numeroInventario);
											//Fin LeerValidarEleccionInventario
										}
										
									break;
									}
									
									if (!gestora.comprobarEnemigoMuerto (partidaDefinitiva.getMazmorra()) && !muerto)
									{
										//LeerValidarEleccionCombate
										do
										{
											try
											{
												gestora.interfazCombate(partidaDefinitiva);
												eleccionCombate = teclado.nextInt();
											}
											catch (InputMismatchException e)
											{
												eleccionCombate = -1;
												System.out.println();
												System.out.println("Ja ja que gracioso.");
												System.out.println();
												teclado.next();
											}
										}
										while (eleccionCombate < 0 || eleccionCombate > 2);
										//Fin LeerValidarEleccionCombate
									}
									
									else
									{
										eleccionCombate = 0;
									}
								}
							}
							
							else
							{
								System.out.println("Deja de buscar pelea con las paredes y primero encuentra un enemigo.");
							}
							
						break;
						
						//Avanzar
						case 4:
							//LeerValidarPosicion
							do
							{
								try
								{
									partidaDefinitiva.getMazmorra ().printMazmorra ();
									menuMovimiento ();
									posicion = teclado.nextInt ();
								}
								catch (InputMismatchException e)
								{
									posicion = -1;
									System.out.println();
									System.out.println("Ja ja que gracioso.");
									System.out.println();
									teclado.next();
								}
							}
							while (posicion < 0 || posicion > 4);
							//Fin LeerValidarPosicion
							
							if (posicion != 0)
							{
								partidaDefinitiva.setMazmorra(gestora.moverJugador (partidaDefinitiva.getMazmorra(), posicion));
							}
							
							if (gestora.comprobarFinNivel(partidaDefinitiva.getMazmorra()))
							{
								//LeerValidarAvanzarSiguienteNivel
								do
								{
									System.out.println();
									System.out.println("�Quieres avanzar al siguiente nivel?");
									System.out.println();
									avanzar = Character.toLowerCase(teclado.next ().charAt (0));
								}
								while (avanzar != 's' && avanzar != 'n');
								//Fin LeerValidarAvanzarSiguienteNivel
								
								if (avanzar == 's')
								{
									partidaDefinitiva.setMazmorra(gestoraAleatoria.generarMazmorraAleatoria());
								}
							}
							
						break;
						
						//Abrir inventario
						case 5:
							//LeerValidarEleccionInventario
							do
							{
								try
								{
									numeroInventario = gestora.monstrarInventario(partidaDefinitiva.getJugador());
									eleccionInventario = teclado.nextInt();
								}
								catch (InputMismatchException e)
								{
									eleccionInventario = -1;
									System.out.println();
									System.out.println("Ja ja que gracioso.");
									System.out.println();
									teclado.next();
								}
							}
							while (eleccionInventario < 0 || eleccionInventario > numeroInventario);
							//Fin LeerValidarEleccionInventario
							
								while (eleccionInventario != 0)
								{
									//LeerValidarUtilizarItem
									do
									{
										System.out.println();
										System.out.println("�Quieres utilizar este objeto?");
										System.out.println();
										utilizar = Character.toLowerCase(teclado.next().charAt(0));
									}
									while (utilizar != 's' && utilizar != 'n');
									//Fin LeerValidarUtilizarItem
									
									if (utilizar == 's')
									{
										resultadoInventario = gestora.utilizarItem (partidaDefinitiva.getJugador(), eleccionInventario);
										
										if (resultadoInventario)
										{
											System.out.println();
											System.out.println("Haz utilizado el item con �xito!");
											System.out.println();
										}
										
										else
										{
											System.out.println();
											System.out.println("No puedes utilizar una poci�n de efecto temporal fuera de combate!");
											System.out.println();
										}
									}
									
									//LeerValidarEleccionInventario
									do
									{
										try
										{
											numeroInventario = gestora.monstrarInventario(partidaDefinitiva.getJugador());
											eleccionInventario = teclado.nextInt();
										}
										catch (InputMismatchException e)
										{
											eleccionInventario = -1;
											System.out.println();
											System.out.println("Ja ja que gracioso.");
											System.out.println();
											teclado.next();
										}
									}
									while (eleccionInventario < 0 || eleccionInventario > numeroInventario);
									//Fin LeerValidarEleccionInventario
								}
							
						break;

						//Mostrar mapa
						case 6:
							partidaDefinitiva.getMazmorra ().printMazmorra ();
						break;
					}// Fin_segun
					
					// PrintMenuLeerValidarAcciones
					if (!muerto)
					{
						do
						{
							try
							{
								menuAcciones ();
								accion = teclado.nextInt();
							}
							catch (InputMismatchException e)
							{
								accion = -1;
								System.out.println();
								System.out.println("Ja ja que gracioso.");
								System.out.println();
								teclado.next();
							}
						}
						while (accion < 0 || accion > 6);
					}
					
					else
					{
						accion = 0;
					}
					//Fin PrintMenuLeerValidarAcciones
					
				}// Fin_Mientras
				
				//Fin Jugar
				
				//GuardarPartida *
				if (!muerto)
				{
					gestora.guardarPartida(partidaDefinitiva.getMazmorra (), partidaDefinitiva.getJugador (), numeroPartida);
				}
				//Fin GuardarPartida
				
				//PrintEstadoPartida *
				if (!muerto)
				{
					System.out.println("Este es el estado de tu partida actual:");
					System.out.println();
					partidaDefinitiva.imprimirJugador();
				}
				//Fin PrintEstadoPartida
			
			//Fin EjecutarJuego
		
			//Preguntar JugarOtraVez
			do
			{
				System.out.println("Quieres volver a jugar a EstoNoTieneNadaQueVerConIsaac? S/N");
				ejecutar = Character.toLowerCase(teclado.next().charAt(0));
			}
			while (ejecutar != 's' && ejecutar != 'n');
			
			partidaDefinitiva = null;
			muerto = false;
			//Fin Preguntar JugarOtraVez
		
		}//Fin_Mientras QuieraJugar
	}//Fin_Main
}//Fin_Clase