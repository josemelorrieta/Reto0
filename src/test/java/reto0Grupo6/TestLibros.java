package reto0Grupo6;
import static org.junit.Assert.*;

import org.junit.Test;

import reto0Grupo6.Libro;

public class TestLibros { 

	private String autor = "autor1";
	private String titulo = "titulo1";
	private String editorial = "editorial1";
	private int paginas = 100;
	private float altura = (float) 25.3;
	private String notas = "anotaciones1";
	private String isbn = "978-84-945696-8-5";
	private String materias = "Cuentos";
	
	private Libro libro = new Libro(autor, titulo, editorial, paginas,altura,notas, isbn, materias);
	
	
	@Test
	public void testContructorAlumno() {
		Libro libroPrueba = new Libro(autor, titulo, editorial, paginas,altura,notas, isbn, materias);
		assertEquals(autor,libroPrueba.getAutor());
		assertEquals(titulo,libroPrueba.getTitulo());
		assertEquals(editorial,libroPrueba.getEditorial());
		assertEquals(paginas,libroPrueba.getPaginas()); 
		assertEquals(altura,libroPrueba.getAltura(),0.2);
		assertEquals(notas,libroPrueba.getNotas());
		assertEquals(isbn,libroPrueba.getIsbn());
		assertEquals(materias,libroPrueba.getMaterias());
	}
	
	@Test
	public void testAutor() {
		libro.setAutor(autor);
		assertEquals(autor,libro.getAutor());
	}
	
	@Test
	public void testAutorMal() {
		libro.setAutor(autor);
		assertNotEquals("autormal",libro.getAutor());
	}
	
	@Test
	public void testTitulo() {
		libro.setTitulo(titulo);
		assertEquals(titulo,libro.getTitulo());
	}
	
	@Test
	public void testTituloMal() {
		libro.setTitulo(titulo);
		assertNotEquals("iuhi",libro.getTitulo());
	}
	
	@Test
	public void testEditorial() {
		libro.setEditorial(editorial);
		assertEquals(titulo,libro.getTitulo());
	}
	
	@Test
	public void testEditorialMal() {
		libro.setEditorial(editorial);
		assertNotEquals("dfhdrftgyh",libro.getTitulo());
	}
	
	@Test
	public void testPaginas() {
		libro.setPaginas(paginas);
		assertEquals(paginas,libro.getPaginas());
	}
	
	@Test
	public void testPaginasMal() {
		libro.setPaginas(paginas);
		assertNotEquals(101,libro.getPaginas());
	}
	
	@Test
	public void testAltura() {
		libro.setAltura(altura);
		assertEquals(altura,libro.getAltura(),0.2);
	}
	
	@Test
	public void testAlturaMal() {
		libro.setAltura(altura);
		assertNotEquals(120,libro.getAltura(),0.2);
	}
	
	@Test
	public void testNotas() {
		libro.setNotas(notas);
		assertEquals(notas,libro.getNotas());
	}
	
	@Test
	public void testNotasMal() {
		libro.setNotas(notas);
		assertNotEquals("asbdioawsdbi",libro.getNotas());
	}
	
	@Test
	public void testiSBN() {
		libro.setIsbn(isbn);;
		assertEquals(isbn,libro.getIsbn());
	}
	
	@Test
	public void testiSBNMal() {
		libro.setIsbn(isbn);;
		assertNotEquals("kjhgvbkj",libro.getIsbn());
	}
	
	@Test
	public void testMaterias() {
		libro.setMaterias(materias);
		assertEquals(materias,libro.getMaterias());
	}
	
	@Test
	public void testMateriasMal() {
		libro.setMaterias(materias);
		assertNotEquals("asd",libro.getMaterias());
	}
	
	@Test
	public void testToString() {
		String resultado = libro.toString();
		String expected ="RESULTADOS DE LA BÚSQUEDA DE SU LIBRO:" + "\n"+ 
				" Autor: " + "autor1" + "\n"+
				"Título: " + "titulo1" + "\n"+
				"Editorial: " + "editorial1" + "\n"+ 
				"Descripción física: " + 100 + "p. ; " + 25.3 + "cm."+ "\n"+ 
				"Notas: " + "anotaciones1" + "\n"+
				"ISBN: " + "978-84-945696-8-5" + "\n"+
				"Materias: " + "Cuentos";
		assertEquals(resultado,expected);
		
	}
	
	@Test
	public void testToStringMal() {
		String resultado = libro.toString();
		String expected ="dfgdfgfhfg:" + "\n"+ 
				" Autor: " + "autor1" + "\n"+
				"Título: " + "titulo1" + "\n"+
				"Editorial: " + "editorial1" + "\n"+ 
				"Descripción física: " + 100 + "p. ; " + 25.3 + "cm."+ "\n"+ 
				"Notas: " + "anotaciones1" + "\n"+
				"ISBN: " + "978-84-945696-8-5" + "\n"+
				"Materias: " + "Cuentos";
		assertNotEquals(resultado,expected);
		
	}
	 
	

}
