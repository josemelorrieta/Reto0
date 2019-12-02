package reto0Grupo6;

public class Libro {
	
	//Declaración e inicialización de variables
	private String autor;
	private String titulo;
	private String editorial;
	private int paginas;
	private float altura;
	private String notas;
	private String isbn;
	private String materias;
	
	//Constructor
	public Libro() {
		
	}
	
	public Libro(String autor, String titulo, String editorial, int paginas, float altura, String notas, String isbn,
			String materias) {
		this.autor = autor;
		this.titulo = titulo;
		this.editorial = editorial;
		this.paginas = paginas;
		this.altura = altura;
		this.notas = notas;
		this.isbn = isbn;
		this.materias = materias;
	}




	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getMaterias() {
		return materias;
	}

	public void setMaterias(String materias) {
		this.materias = materias;
	}




	@Override
	public String toString() {
		return "RESULTADOS DE LA BÚSQUEDA DE SU LIBRO:" + "\n"+ 
				" Autor: " + this.autor + "\n"+
				"Título: " + this.titulo + "\n"+
				"Editorial: " + this.editorial + "\n"+ 
				"Descripción física: " + this.paginas + "p. ; " + this.altura + "cm."+ "\n"+ 
				"Notas: " + this.notas + "\n"+
				"ISBN: " + this.isbn + "\n"+
				"Materias: " + this.materias;
	}



}
