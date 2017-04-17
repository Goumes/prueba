package Pruebas;

import java.io.*;

public class pruebaFileReaderFileWriter 
{
	public static void main (String [] args)
	{
		try
		{
			FileWriter fw = new FileWriter ("pepejava2.txt");
			fw.write("Esto es una prueb");
			fw.write(97);
			fw.close();
			
			FileReader fr = new FileReader ("pepejava2.txt");
			int valor = fr.read();
			
			while (valor != -1)
			{
				System.out.print((char) valor);
				valor = fr.read();
			}
			
			fr.close();
		}
		catch (IOException error)
		{
			System.out.println("Error E/S: "+error);
		}
	}
}