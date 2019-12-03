package reto0Grupo6;

import java.io.File;//Esta clase permite obtener información sobre cualquier elemento del sistema de archivos.
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class GestionFicheros {

	public void listarArchivosCarpeta() { // Permite listar todos los archivos de una carpeta seleccionada por el usuario

		LeerFicheros leerFicheros = new LeerFicheros();
		EscribirFicheros escribirFicheros = new EscribirFicheros();

		// Aquí es donde elegimos la carpeta
		String ruta = escribirFicheros.elegirCarpeta();
		File carpeta = new File(ruta);

		String[] listado = carpeta.list();
		if (listado == null || listado.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual");
			return;
		} else {
			for (int i = 0; i < listado.length; i++) {
				System.out.println(listado[i]);
			}
		}
	}

	public void verDetallesArchivosCarpeta() {// Permite ver los detalles de todos los archivos de una carpeta
												// seleccionada por el usuario
		EscribirFicheros escribirFicheros = new EscribirFicheros();
		String ruta = escribirFicheros.elegirCarpeta();
		File carpeta = new File(ruta);

		File[] archivos = carpeta.listFiles();
		if (archivos == null || archivos.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual");
			return;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // fecha y hora de creación
			for (int i = 0; i < archivos.length; i++) {
				File archivo = archivos[i];
				System.out.println(String.format("%s (%s) - %d - %s", archivo.getName(), // el nombre del archivo o
																							// carpeta
						archivo.isDirectory() ? "Carpeta" : "Archivo", // indica si el objeto actual representa a una
																		// carpeta o no
						archivo.length(), // el tamaño del archivo en bytes.
						sdf.format(archivo.lastModified())));
			}
		}

	}

	public void verDetallesUnArchivo() {// Permite ver los detalles de un archivo seleccionada por el usuario
		FileNameExtensionFilter filter = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		fileChooser.showDialog(null, "Abrir");

		File archivo = fileChooser.getSelectedFile(); // Se selecciona el archivo

		if (archivo == null) {
			System.out.println("No hay archivos seleccionados");
			return;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // fecha y hora de creación

			System.out.println("Nombre: " + archivo.getName() + "\n" + // el nombre del archivo o carpeta
					"Tamaño: " + archivo.length() + " bytes" + "\n" + // el tamaño del archivo en bytes.
					"Fecha y hora: " + sdf.format(archivo.lastModified()) + "\n" + // fecha y hora de creación
					"Permisos lectura: " + archivo.canRead() + "\n" + "Permisos escritura: " + archivo.canWrite() + "\n"
					+ "Permisos edición: " + archivo.canExecute() + "\n" + "Ruta absoluta: " + archivo.getAbsolutePath()
					
					+ "\n" + "Última modificación: " + sdf.format(archivo.lastModified()) + "\n");

		}
	}
	
	public void obtenerPropietarioArchivo() {
		 try {
			 
			 FileNameExtensionFilter filter = null;
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(filter);
				fileChooser.showDialog(null, "Abrir");

				File archivo = fileChooser.getSelectedFile(); // Se selecciona el archivo
			 
	            String fileName = "./PropietarioArchivo.java";
	            Path path = Paths.get(archivo.toString());
	            System.out.println(path);
	         //   UserPrincipal propietario = archivo.getOwner(path); //.getOwner(path) no va
	         //  String username = propietario.getName();
	         //  System.out.println("El propietario del archivo : " + fileName + " es : "+ propietario);
	 
	        } catch (Exception e) {
	            System.out.println("Exception: " + e.toString());
	        }
	}
	
	public void editarArchivo() {
		
		Scanner reader = new Scanner(System.in);
		LeerDatos leerDatos = new LeerDatos();
		EscribirFicheros escribirFicheros = new EscribirFicheros();
		
		FileNameExtensionFilter filter = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		fileChooser.showDialog(null, "Abrir");

		File archivo = fileChooser.getSelectedFile(); // Se selecciona el archivo

		if (archivo == null) {
			System.out.println("No hay archivos seleccionados");
			return;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // fecha y hora de creación

			System.out.println("Nombre: " + archivo.getName() + "\n" + // el nombre del archivo o carpeta
					"Tamaño actual: " + archivo.length() + " bytes" + "\n" // el tamaño del archivo en bytes.
					);
			
			
			// Editar tamaño
			int tamanio = leerDatos.RecogerOpcionInt(reader, 0, 9999, "Introduzca el nuevo tamaño del archivo");
			System.out.println("El tamaño introducido es: " + tamanio);
			
			
			
			//Editar propietario
			
			//Editar permisos
			//-Permisos lectura
			int respuestaLectura = leerDatos.RecogerOpcionInt(reader,0,1, "¿Desea permitir su lectura? (Introduzca: 0 = no / 1 = si) " );
			if (respuestaLectura==0) {
				archivo.setReadable(false,false);
				System.out.println("Permisos lectura: " + archivo.canRead());
			}
			if (respuestaLectura==1) {
				archivo.setReadable(true);
				System.out.println("Permisos lectura: " + archivo.canRead());
			}
			
			//-Permisos escritura
			int respuestaEscritura = leerDatos.RecogerOpcionInt(reader,0,1, "¿Desea permitir su escritura? (Introduzca: 0 = no / 1 = si) " );
			if (respuestaEscritura==0) {
				archivo.setWritable(false);
				System.out.println("Permisos escritura: " + archivo.canWrite());
			}
			if (respuestaEscritura==1) {
				archivo.setWritable(true);
				System.out.println("Permisos escritura: " + archivo.canWrite());
			}
			//-Permisos ejecución
			int respuestaEjecucion = leerDatos.RecogerOpcionInt(reader,0,1, "¿Desea permitir su ejecución? (Introduzca: 0 = no / 1 = si) " );
			if (respuestaEjecucion==0) {
				archivo.setWritable(false);
				System.out.println("Permisos ejecución: " + archivo.canExecute());
			}
			if (respuestaEjecucion==1) {
				archivo.setWritable(true);
				System.out.println("Permisos ejecución: " + archivo.canExecute());
			}
		}
	}

	public void crearFichero() {
		File carpeta = null;
		String nombreFichero = "";
		boolean bool = false;
		Scanner reader = new Scanner(System.in);
		LeerDatos leerDatos = new LeerDatos();
		
		EscribirFicheros escribirFicheros = new EscribirFicheros();
		//1º El usuario escoje la ruta en la que quiere crear el fichero
		String ruta = escribirFicheros.elegirCarpeta();
		
		//El usuario introduce el nombre del fichero
		nombreFichero = leerDatos.IntroducirTexto(reader, "Introduzca el nombre del fichero: ");

		try {
			// returns pathnames for files and directory
			//carpeta = new File(ruta);
			carpeta = new File(ruta.toString()+"\\"+ nombreFichero.toString());
			// create
			bool = carpeta.mkdir();

			if(bool){
				System.out.print("El fichero" + ruta.toString()+"\\"+ nombreFichero.toString()+ " se creo correctamente. "  );
			}
			else
				System.out.print("El fichero" + ruta.toString()+"\\"+ nombreFichero.toString()+ " NO pudo crearse. "  );
			

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}
	
	public void crearArchivo() {
		File archivo = null;
		String nombreArchivo = "";
		boolean bool = false;
		Scanner reader = new Scanner(System.in);
		LeerDatos leerDatos = new LeerDatos();
		
		EscribirFicheros escribirFicheros = new EscribirFicheros();
		//1º El usuario escoje la ruta en la que quiere crear el fichero
		String ruta = escribirFicheros.elegirCarpeta();
		
		//El usuario introduce el nombre del fichero
		nombreArchivo = leerDatos.IntroducirTexto(reader, "Introduzca el nombre del archivo (no olvide la extensión .txt, .csv, .xml: ");

		try {
			// returns pathnames for files and directory
			//carpeta = new File(ruta);
			archivo = new File(ruta.toString()+"\\"+ nombreArchivo.toString());
			// create
			bool = archivo.createNewFile();

			if(bool){
				System.out.print("El archivo" + ruta.toString()+"\\"+ nombreArchivo.toString()+ " se creo correctamente. "  );
			}
			else
				System.out.print("El archivo" + ruta.toString()+"\\"+ nombreArchivo.toString()+ " NO pudo crearse. "  );
			

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}
	
	public void eliminarArchivos() {
		
		FileNameExtensionFilter filter = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		fileChooser.showDialog(null, "Abrir");

		// 1º Se selecciona el archivo
		File archivo = fileChooser.getSelectedFile(); 
		
		archivo.delete();
		
		System.out.println("El archivo " + archivo.toString() + " fue eliminado correctamente.");
		
	}
	
	public void cambiarUbicacionArchivo() {
		
		FileNameExtensionFilter filter = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		fileChooser.showDialog(null, "Abrir");
		EscribirFicheros escribirFicheros = new EscribirFicheros();

		// 1º Se selecciona el archivo
		File origen = fileChooser.getSelectedFile(); 
		
		//2º El usuario escoje la ruta en la que quiere crear el fichero
		String ruta = escribirFicheros.elegirCarpeta();
		
		
        File destino = new File(ruta.toString()+"\\"+ origen.getName().toString()); 

         try {
                 InputStream in = new FileInputStream(origen);
                 OutputStream out = new FileOutputStream(destino);
                 System.out.println("El archivo" + origen + " se cambió de ubicación correctamente a " + destino);
                 byte[] buf = new byte[1024];
                 int len;

                 while ((len = in.read(buf)) > 0) {
                         out.write(buf, 0, len);
                 }

                 in.close();
                 out.close();
         } catch (IOException ioe){
                 ioe.printStackTrace();
         }

        
         
	}
	
	
	
}
