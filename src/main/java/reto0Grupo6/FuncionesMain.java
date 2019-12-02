package reto0Grupo6;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncionesMain {
	
	LeerFicheros leerFicheros = new LeerFicheros();
	EscribirFicheros escribirFicheros = new EscribirFicheros();
	 
	public void MostrarDatosLibro(ArrayList<Libro> libros,Scanner reader) {
		// Declaracion e inicializacion de variables
		String autor = "";
		boolean encontrado = false;
		//Inicio de programa
		System.out.println("Introduce en nombre completo del autor: ");
		autor = reader.nextLine();
		for(int i = 0;i<libros.size();i++)
		{
			if(libros.get(i).getAutor().equalsIgnoreCase(autor))
			{
				System.out.println(libros.get(i).toString());
				encontrado = true;
			}
		}
		if(!encontrado)
			System.out.println("Libro no encontrado");
		 
	}

	public void MostrarDatos(ArrayList<Libro> libros) {
		//Inicio de programa
		System.out.println("\t Listado de Libros");
		System.out.println("---------------------------");
		System.out.println("Autor    \t Título \tEditorial\t Descripción física\t Notas \t ISBN \t Materias \t ");
		System.out.println("----------\t-----\t -----\t ---------\t---------\t ");
		
		for(int i = 0;i<libros.size();i++)
		{
			System.out.println(libros.get(i).getAutor()+"\t "+libros.get(i).getTitulo()+"\t "+libros.get(i).getEditorial() 
					+"\t "+libros.get(i).getPaginas()+"p. ;"+libros.get(i).getAltura() +"cm. \t " + libros.get(i).getNotas() 
					+ "\t \t" + libros.get(i).getIsbn() +"\t \t" + libros.get(i).getMaterias());
		}
	}


	public String mostrarMenu() {
		//Inicio de programa
		String mensajeMenu = "";
		
		mensajeMenu = "\t MENÚ PRINCIPAL" + "\n" +
				"\t --------------" + "\n" +
				"1.- Cargar datos libros"+ "\n" + 
				"2.- Mostrar catálogo"+ "\n" + 
				"3.- Búsqueda de un libro (por autor)" + "\n" + 
				"4.- Importar catálogo" + "\n" +
				"5.- Exportar catálogo"+ "\n" +
				"6.- Gestión de ficheros" + "\n" +
				"0.- Fin";
		return mensajeMenu;
	}
	
	public ArrayList<Libro> menuImportar(ArrayList<Libro> libros, Scanner reader, LeerDatos leerDatos) {
		int opcion = -1;
		String mensajeMenu = "";
		
		while (opcion !=0)
		{
			switch (opcion) {
				case 1: libros = leerFicheros.leerFicheroTXT(libros); 
					break;
				case 2: libros = leerFicheros.leerFicheroCSV(libros);
					break;
				case 3: libros = leerFicheros.leerFicheroXML(libros);
					break;	 
			}	
			mensajeMenu = mostrarMenuImportar();
			System.out.println(mensajeMenu);
			opcion = leerDatos.RecogerOpcionInt(reader,0,3, "Introduce una opción: ");
		}
		
		return libros;
	}
	
	public ArrayList<Libro> menuExportar(ArrayList<Libro> libros, Scanner reader, LeerDatos leerDatos) {
		int opcion = -1;
		String mensajeMenu = "";
		
		while (opcion !=0)
		{
			switch (opcion) {
				case 1: if(libros.size() != 0) {
						escribirFicheros.escribirTxt(libros);
					} else {
						System.out.println("No hay libros en el catálogo");
					}
					break;
				case 2: if(libros.size() != 0) {
						escribirFicheros.escribirCsv(libros);
					} else {
						System.out.println("No hay libros en el catálogo");
					}
					break;
				case 3: if(libros.size() != 0) {
						escribirFicheros.escribirXml(libros);
					} else {
						System.out.println("No hay libros en el catálogo");
					}
					break;
			}
			
			mensajeMenu = mostrarMenuExportar();
			System.out.println(mensajeMenu);
			opcion = leerDatos.RecogerOpcionInt(reader,0,3, "Introduce una opción: ");
		}
		return libros;
	}
	
	public void menuFicheros(Scanner reader, LeerDatos leerDatos) {
		int opcion = -1;
		String mensajeMenu = "";
		
		GestionFicheros gestionFicheros = new GestionFicheros();
		
		while (opcion !=0)
		{
			switch (opcion) {
				case 1: gestionFicheros.verDetallesArchivosCarpeta();
					break;
				case 2: gestionFicheros.verDetallesUnArchivo();
				break;
				case 3: gestionFicheros.editarArchivo();
					break;
				case 4: gestionFicheros.crearFichero();
					break;
				case 5: gestionFicheros.crearArchivo();
					break;
				case 6: gestionFicheros.eliminarArchivos();
					break;
				case 7: gestionFicheros.cambiarUbicacionArchivo();
					break;
			}	
			mensajeMenu = mostrarMenuGestionFicheros();
			System.out.println(mensajeMenu);
			opcion = leerDatos.RecogerOpcionInt(reader,0,7, "Introduce una opción: ");
		}
	}
	
	public String mostrarMenuImportar() {
		//Inicio de programa
		String mensajeMenu = "";
		
		mensajeMenu = "\t IMPORTAR CATÁLOGO" + "\n" +
				"\t -----------------" + "\n" +
				"1.- Importar desde archivo .TXT"+ "\n" + 
				"2.- Importar desde archivo .CSV"+ "\n" + 
				"3.- Importar desde archivo .XML" + "\n" + 
				"0.- Volver al menú principal";
		return mensajeMenu;
	}
	
	public String mostrarMenuExportar() {
		//Inicio de programa
		String mensajeMenu = "";
		
		mensajeMenu = "\t EXPORTAR CATÁLOGO" + "\n" +
				"\t -----------------" + "\n" +
				"1.- Exportar a archivo .TXT"+ "\n" + 
				"2.- Exportar a archivo .CSV"+ "\n" + 
				"3.- Exportar a archivo .XML" + "\n" + 
				"0.- Volver al menú principal";
		return mensajeMenu;
	}
	
	public String mostrarMenuGestionFicheros() {
		//Inicio de programa
		String mensajeMenu = "";
		
		mensajeMenu = "\t GESTIÓN DE FICHEROS" + "\n" +
				"\t -----------------" + "\n" +
				"1.- Ver detalles de todos los archivos de un fichero"+ "\n" + 
				"2.- Ver detalles de un archivo concreto"+ "\n" + 
				"3.- Editar fichero" + "\n" + 
				"4.- Crear fichero" + "\n" + 
				"5.- Crear archivo" + "\n" + 
				"6.- Eliminar archivo" + "\n" + 
				"7.- Cambiar ubicación de un archivo" + "\n" + 
				"0.- Volver al menú principal";
		return mensajeMenu;
	}


	public ArrayList<Libro> CargarDatos(Scanner reader, LeerDatos leerDatos, ArrayList<Libro> libros) {
		//Declaracion e inicialización de variables
		String autor;
		String titulo;
		String editorial;
		int paginas;
		float altura;
		String notas;
		String isbn;
		String materias;
		
		Libro nuevoLibro;
		
		//Inicio de programa
		autor = leerDatos.IntroducirTexto(reader, "Introduzca el autor:");
		titulo = leerDatos.IntroducirTexto(reader, "Introduzca el título:");
		editorial = leerDatos.IntroducirTexto(reader, "Introduzca la editorial:");
		paginas= leerDatos.RecogerOpcionInt(reader,0,5000,"Introduzca el número de páginas: ");
		altura= leerDatos.RecogerOpcionFloat(reader,0,(float) 100,"Introduce la altura (cm): ");
		notas = leerDatos.IntroducirTexto(reader, "Introduzca alguna anotación del libro:");
		isbn = leerDatos.IntroducirTexto(reader, "Introduzca el ISBN:");
		materias = leerDatos.IntroducirTexto(reader, "Introduzca la temática (Ej. Novela clásica, cuentos,...):");
		
		nuevoLibro = new Libro(autor, titulo, editorial, paginas, altura, notas, isbn, materias);
		
		libros.add(nuevoLibro);
		
		return libros;
	}
	
	public String mostrarDatosLibro(ArrayList<Libro> libros,Scanner reader, LeerDatos leerDatos ) {
		// Declaracion e inicializacion de variables
		String autor = "";
		boolean encontrado = false;
		String respuesta = "";
		//Inicio de programa
		
		autor = leerDatos.IntroducirTexto(reader, "Introduce en nombre completo del autor: ");
		
		for(Libro libro: libros) {
			if(libro.getAutor().equalsIgnoreCase(autor))
			{
				respuesta = libro.toString();
				encontrado = true;
			}
		}
		if(!encontrado)
			respuesta = "Libro no encontrado";
		
		 return respuesta;
	}

	public String mostrarDatos(ArrayList<Libro> libros) { 
		String datosLibros ="";
		//Inicio de programa
		datosLibros = "\t Listado de Libros" + "\n" + 
					"-------------------------------------------------------" + "\n" + 
					"Autor    \t Título \tEditorial\t Descripción física\t Notas \t ISBN \t Materias \t "+ "\n" + 
					"-------------------------------------------------------------------------------------------------" + "\n" ;
		
		for (Libro libro: libros) {
			datosLibros = datosLibros +
					libro.getAutor()+"\t "+libro.getTitulo()+"\t "+libro.getEditorial() 
					+"\t "+libro.getPaginas()+"p. ;"+libro.getAltura() +"cm. \t " + libro.getNotas() 
					+ "\t \t" + libro.getIsbn() +"\t \t" + libro.getMaterias();
		}
		
		return datosLibros;
	}

	
	

}

