package reto0Grupo6;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class LeerDatosTest {

	@Test
	public void testintroducirTexto() {
		LeerDatos leerDatos = new LeerDatos();

		String resultado;
		String texto = "Introduzca un autor";
		String input = "Autor";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    Scanner reader = new Scanner(System.in);
	    reader.useDelimiter("\\r\\n");
	    
	    resultado = leerDatos.IntroducirTexto(reader, texto);
	    assertEquals("Autor", resultado);
	}
	

	@Test
	public void testRecogerOpcionInt() {
		LeerDatos leerDatos = new LeerDatos();

		int resultadoInt;
		String texto = "Introduzca un número";
		int valorMin = 0;
		int valorMax = 10;
		String input = "5 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoInt = leerDatos.RecogerOpcionInt(reader, valorMin, valorMax,texto);
	    assertEquals(5, resultadoInt);
	
	}
	
	@Test
	public void testRecogerOpcionInt2() {
		LeerDatos leerDatos = new LeerDatos();

		int resultadoInt;
		String texto = "Introduzca un número";
		int valorMin = 0;
		int valorMax = 10;
		String input = "15 4 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoInt = leerDatos.RecogerOpcionInt(reader, valorMin, valorMax,texto);
	    assertEquals(4, resultadoInt);
	
	}
	
	@Test
	public void testRecogerOpcionInt3() {
		LeerDatos leerDatos = new LeerDatos();

		int resultadoInt;
		String texto = "Introduzca un número";
		int valorMin = 0;
		int valorMax = 10;
		String input = "-1 4 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoInt = leerDatos.RecogerOpcionInt(reader, valorMin, valorMax,texto);
	    assertEquals(4, resultadoInt);
	
	}
	
	@Test
	public void testRecogerOpcionInt4() {
		LeerDatos leerDatos = new LeerDatos();

		int resultadoInt;
		String texto = "Introduzca un número";
		int valorMin = 0;
		int valorMax = 10;
		String input = "a \n 4 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoInt = leerDatos.RecogerOpcionInt(reader, valorMin, valorMax,texto);
	    assertEquals(4, resultadoInt);
	
	}
	
	@Test
	public void testRecogerOpcionFloat() {
		LeerDatos leerDatos = new LeerDatos();

		float resultadoFloat;
		String texto = "Introduzca un número";
		float valorMin = 0f;
		float valorMax = 10f;
		String input = "5 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoFloat = leerDatos.RecogerOpcionFloat(reader, valorMin, valorMax,texto);
	    assertEquals(5, resultadoFloat, 0.0);
	
	}
	
	@Test
	public void testRecogerOpcionFloat2() {
		LeerDatos leerDatos = new LeerDatos();

		float resultadoFloat;
		String texto = "Introduzca un número";
		float valorMin = 0f;
		float valorMax = 10f;
		String input = "15 \n 4 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoFloat = leerDatos.RecogerOpcionFloat(reader, valorMin, valorMax,texto);
	    assertEquals(4, resultadoFloat, 0.0);
	
	}
	
	@Test
	public void testRecogerOpcionFloat3() {
		LeerDatos leerDatos = new LeerDatos();

		float resultadoFloat;
		String texto = "Introduzca un número";
		float valorMin = 0f;
		float valorMax = 10f;
		String input = "-1 \n 4 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoFloat = leerDatos.RecogerOpcionFloat(reader, valorMin, valorMax,texto);
	    assertEquals(4, resultadoFloat, 0.0);
	
	}
	
	@Test
	public void testRecogerOpcionFloat4() {
		LeerDatos leerDatos = new LeerDatos();

		float resultadoFloat;
		String texto = "Introduzca un número";
		float valorMin = 0f;
		float valorMax = 10f;
		String input = "a \n 4 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner reader = new Scanner(System.in); 
	    resultadoFloat = leerDatos.RecogerOpcionFloat(reader, valorMin, valorMax,texto);
	    assertEquals(4, resultadoFloat, 0.0);
	
	}

}
