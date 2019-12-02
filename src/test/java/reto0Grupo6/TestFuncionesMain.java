package reto0Grupo6;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class TestFuncionesMain {
	
	private FuncionesMain funciones = new FuncionesMain();
	
	@Test
	public void mostrarMenuTest() {
		String mensajeMenuEsperado = "\t Menu Principal" + "\n" + 
				"1.- Cargar datos libros"+ "\n" + 
				"2.- Mostrar catálogo"+ "\n" + 
				"3.- Búsqueda de un libro (por autor)" + "\n" + 
				"4.- Mostrar catálogo (.TXT)" + "\n" + 
				"5.- Mostrar catálogo (.CSV)"+ "\n" + 
				"6.- Mostrar catálogo (.XML)"+ "\n" + 
				"0.- Fin";
		String mensajeMenuObervado = funciones.mostrarMenu();
		
		assertEquals(mensajeMenuEsperado, mensajeMenuObervado);
	}
	
	@Test
	public void mostrarMenuTestMal() {
		String mensajeMenuEsperado = "fdthftrghfghghgh";
		String mensajeMenuObervado = funciones.mostrarMenu();
		
		assertNotEquals(mensajeMenuEsperado, mensajeMenuObervado);
	}
	
	@Test
	public void cargarDatosTest() {
		LeerDatos datosMock = mock(LeerDatos.class);
		Scanner reader = new Scanner(System.in);
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<Libro> librosTest = new ArrayList<Libro>();
		Libro libroTest = new Libro("Autor", "Título", "Editorial", 100, (float) 20, "Notas", "ISBN", "Materias");
		
		librosTest.add(libroTest);
		
		when(datosMock.IntroducirTexto(reader, "Introduzca el autor:")).thenReturn("Autor");
		when(datosMock.IntroducirTexto(reader, "Introduzca el título:")).thenReturn("Título");
		when(datosMock.IntroducirTexto(reader, "Introduzca la editorial:")).thenReturn("Editorial");
		when(datosMock.RecogerOpcionInt(reader, 0, 5000, "Introduzca el número de páginas: ")).thenReturn(100);
		when(datosMock.RecogerOpcionFloat(reader, 0, (float) 100, "Introduce la altura (cm): ")).thenReturn((float) 20);
		when(datosMock.IntroducirTexto(reader, "Introduzca alguna anotación del libro:")).thenReturn("Notas");
		when(datosMock.IntroducirTexto(reader, "Introduzca el ISBN:")).thenReturn("ISBN");
		when(datosMock.IntroducirTexto(reader, "Introduzca la temática (Ej. Novela clásica, cuentos,...):")).thenReturn("Materias");
		
		ArrayList<Libro> libroResultado = funciones.CargarDatos(reader, datosMock, libros);
		
		assertEquals(libroResultado.get(0).getAutor(), librosTest.get(0).getAutor());
		assertEquals(libroResultado.get(0).getTitulo(), librosTest.get(0).getTitulo());
		assertEquals(libroResultado.get(0).getEditorial(), librosTest.get(0).getEditorial());
		assertEquals(libroResultado.get(0).getPaginas(), librosTest.get(0).getPaginas());
		assertEquals(libroResultado.get(0).getAltura(), librosTest.get(0).getAltura(), 0.1);
		assertEquals(libroResultado.get(0).getNotas(), librosTest.get(0).getNotas());
		assertEquals(libroResultado.get(0).getIsbn(), librosTest.get(0).getIsbn());
		assertEquals(libroResultado.get(0).getMaterias(), librosTest.get(0).getMaterias());
		
		
	}
	
	
	@Test
	public void mostrarDatosLibroTest1() {
		LeerDatos datosMock = mock(LeerDatos.class);
		Scanner reader = new Scanner(System.in);
		
		ArrayList<Libro> librosTest = new ArrayList<Libro>();
		Libro libroTest = new Libro("Autor", "Título", "Editorial", 100, (float) 20, "Notas", "ISBN", "Materias");
		librosTest.add(libroTest);
		
		when(datosMock.IntroducirTexto(reader, "Introduce en nombre completo del autor: ")).thenReturn("Juan");
		
		String respuestEsperada = "Libro no encontrado";
		String respuestObservada = funciones.mostrarDatosLibro(librosTest, reader, datosMock);

		assertEquals(respuestEsperada, respuestObservada);
	}
	
	@Test
	public void mostrarDatosLibroTest2() {
		LeerDatos datosMock = mock(LeerDatos.class);
		Scanner reader = new Scanner(System.in);
		
		ArrayList<Libro> librosTest = new ArrayList<Libro>();
		Libro libroTest = new Libro("Autor", "Título", "Editorial", 100, (float) 20, "Notas", "ISBN", "Materias");
		
		librosTest.add(libroTest);
		
		when(datosMock.IntroducirTexto(reader, "Introduce en nombre completo del autor: ")).thenReturn("Autor");
		
		String respuestEsperada = librosTest.get(0).toString();
		String respuestObservada = funciones.mostrarDatosLibro(librosTest, reader, datosMock);

		assertEquals(respuestEsperada, respuestObservada);
	}
	
	@Test
	public void mostrarDatosTest() {
		ArrayList<Libro> librosTest = new ArrayList<Libro>();
		Libro libroTest = new Libro("Autor", "Título", "Editorial", 100, (float) 20, "Notas", "ISBN", "Materias");
		
		librosTest.add(libroTest);
		
		String datosLibrosEsperado ="\t Listado de Libros" + "\n" + 
				"-------------------------------------------------------" + "\n" + 
				"Autor    \t Título \tEditorial\t Descripción física\t Notas \t ISBN \t Materias \t "+ "\n" + 
				"-------------------------------------------------------------------------------------------------" + "\n"
				+ librosTest.get(0).getAutor()+"\t "+librosTest.get(0).getTitulo()+"\t "+librosTest.get(0).getEditorial() 
					+"\t "+librosTest.get(0).getPaginas()+"p. ;"+librosTest.get(0).getAltura() +"cm. \t " + librosTest.get(0).getNotas() 
					+ "\t \t" + librosTest.get(0).getIsbn() +"\t \t" + librosTest.get(0).getMaterias();
	
		
		String datosLibro = funciones.mostrarDatos(librosTest);
		
		assertEquals(datosLibrosEsperado, datosLibro);
	} 
	
	@Test
	public void mostrarDatosMalTest() {
		ArrayList<Libro> librosTest = new ArrayList<Libro>();
		Libro libroTest = new Libro("Autor", "Título", "Editorial", 100, (float) 20, "Notas", "ISBN", "Materias");
		
		librosTest.add(libroTest);
		
		
		String datosLibrosEsperado ="sdfdsggfdgdf";
	
		
		String datosLibrosObservador = funciones.mostrarDatos(librosTest);
		
		assertNotEquals(datosLibrosEsperado, datosLibrosObservador);
	} 

	
}
