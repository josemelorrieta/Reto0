package reto0Grupo6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class MainReto0 {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
 
		// Declaracion e inicializacion de variables
		LeerDatos leerDatos = new LeerDatos();
		FuncionesMain funciones = new FuncionesMain();
		
		int opcion = -1;
		String mensajeMenu;
		
		Scanner reader = new Scanner(System.in);
		reader.useDelimiter("\\r\\n");
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		 
		//Inicio de programa
		while (opcion !=0)
		{
			switch (opcion) {
				case 1: libros = funciones.CargarDatos(reader, leerDatos, libros);
					break;
				case 2: if(libros.size() != 0) { 
						funciones.MostrarDatos(libros);
					} else {
						System.out.println("El catálogo está vacío");
					}
					break;
				case 3: if(libros.size() != 0) { 
						funciones.MostrarDatosLibro(libros, reader);
					} else {
						System.out.println("El catálogo está vacío");
					}
					break;
				case 4: libros = funciones.menuImportar(libros, reader, leerDatos); 
					break;
				case 5: libros = funciones.menuExportar(libros, reader, leerDatos);
					break;
				case 6: funciones.menuFicheros(reader, leerDatos);
					break;
			}	
			mensajeMenu = funciones.mostrarMenu();
			System.out.println(mensajeMenu);
			opcion = leerDatos.RecogerOpcionInt(reader,0,6, "Introduce una opción: ");
		}
		
		reader.close();

	}

	

}
