package reto0Grupo6;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

public class LeerDatosTest {

	String resultado = null;
	int resultadoInt;
	
	@Test
	public void testintroducirTexto() {
		LeerDatos leerDatos = new LeerDatos();
		
		String texto = "Introduzca un autor";
		String input = "Autor";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner reader = new Scanner(System.in);
	    reader.useDelimiter("\\r\\n");
	    
	    resultado = leerDatos.IntroducirTexto(reader, texto);
	    assertEquals("Autor", resultado);
	}
	
/*
	@Test
	public void testRecogerOpcionInt() {
		LeerDatos leerDatos = new LeerDatos();
		
		String texto = "Introduzca un número";
		int valorMin = 0;
		int valorMax = 10;
		String input = "5";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoInt = leerDatos.RecogerOpcionInt(reader, 0,10,texto);
	    assertEquals(5, resultadoInt);	
	
	}
	
	@Test
	    public void testInputReader() {
		 	LeerDatos leerDatos = new LeerDatos();
		 
		 	String texto = "Introduzca un n�mero";
			int valorMin = 0;
			int valorMax = 10;
			String input = "5";
	        InputStream in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        Scanner reader = new Scanner(System.in);
	        input = "0";
	        in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);
	        input = "10";
	        in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);

	        input = "3";
	        in = new ByteArrayInputStream(input.getBytes());
	        System.setIn(in);

	        assertNotEquals(3, leerDatos.RecogerOpcionInt(reader, 0,10,texto));

	    }
	
  @Test
	public void shouldTakeUserInput() {
	  String texto = "Introduzca un n�mero";
	  String input = "5";
	  InputStream in = new ByteArrayInputStream(input.getBytes());
      System.setIn(in);
      Scanner reader = new Scanner(System.in);
	  
	    //create a mock scanner
	    Scanner mockScanner = mock(Scanner.class);
	    //set up the scanner
	    when(mockScanner.nextLine()).thenReturn("add 5");

	    LeerDatos leerDatos = new LeerDatos();
	    //assert output
        assertNotEquals(3, leerDatos.RecogerOpcionInt(reader, 0,10,texto));

	   //added bonus - you can verify that your scanner's nextline() method is
	   //actually called See Mockito.verify
	   //verify(mockScanner).nextLine();
	}
*/

}
