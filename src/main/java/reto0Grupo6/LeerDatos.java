package reto0Grupo6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerDatos {
	
	public String IntroducirTexto(Scanner reader, String texto) {
		System.out.println(texto);		
		return reader.next(); 
	}
	
	public int RecogerOpcionInt(Scanner reader,int valorMin,int valorMax, String texto ) {
		//Declaracion e inicializaci�n de variables
		int opcion = 0;
		boolean opcionCorrecta = false; 
		//Inicio de programa
		while(!opcionCorrecta)
		{
			try
			{ 
				System.out.println(texto);
				opcion=reader.nextInt();
				while(opcion < valorMin || opcion > valorMax)
				{
					System.out.println("Introduce un valor numérico entre "+valorMin+" y "+valorMax);
					opcion=reader.nextInt();
				}
				reader.nextLine();
				opcionCorrecta = true;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Introduce un valor numérico entre "+valorMin+" y "+valorMax);
				reader.nextLine();
			}
			
		}
		return opcion;
	}
	
	public float RecogerOpcionFloat(Scanner reader,float valorMin,float valorMax, String texto ) {
		
		//Declaracion e inicialización de variables
		float opcion = 0;
		boolean opcionCorrecta = false; 
		//Inicio de programa
		while(!opcionCorrecta)
		{
			try
			{
				System.out.println(texto);
				opcion=reader.nextFloat();
				while(opcion < valorMin || opcion > valorMax)
				{
					System.out.println("Introduce un valor numérico entre "+valorMin+" y "+valorMax);
					opcion=reader.nextFloat();
				}
				reader.nextLine();
				opcionCorrecta = true;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Introduce un valor numérico entre "+valorMin+" y "+valorMax);
				reader.nextLine();
			}
			
		}
		return opcion;
	}
}
