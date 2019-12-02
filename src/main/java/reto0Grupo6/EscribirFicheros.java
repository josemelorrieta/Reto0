package reto0Grupo6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class EscribirFicheros {
	public void escribirTxt(ArrayList<Libro> libros) {
		FileWriter fichero = null;
		String ruta = elegirCarpeta();
		
		try {
			fichero = new FileWriter(ruta + "\\Catalogo Exportado.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fichero != null) {
			BufferedWriter writer = new BufferedWriter(fichero);
			PrintWriter printW = new PrintWriter(writer);
			try {
				for (int i=0;i<libros.size();i++) {
					printW.println("Autor: " + libros.get(i).getAutor());
					printW.println("Título: " + libros.get(i).getTitulo());
					printW.println("Editorial: " + libros.get(i).getEditorial());
					printW.println("Páginas: " + libros.get(i).getPaginas());
					printW.println("Altura: " + libros.get(i).getAltura());
					printW.println("Notas: " + libros.get(i).getNotas());
					printW.println("ISBN: " + libros.get(i).getIsbn());
					printW.println("Materias: " + libros.get(i).getMaterias());
					printW.println();
				}
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Hubo un error a la hora de generar el fichero.");
		}
	}
	
	public void escribirCsv(ArrayList<Libro> libros) {
		FileWriter fichero = null;
		String ruta = elegirCarpeta();
		
		try {
			fichero = new FileWriter(ruta + "\\Catalogo Exportado.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fichero != null) {
			BufferedWriter writer = new BufferedWriter(fichero);
			PrintWriter printW = new PrintWriter(writer);
			try {
				printW.println("Autor;Título;Editorial;Páginas;Altura;Notas;ISBN;Materias");
				for (int i=0;i<libros.size();i++) {
					printW.print(libros.get(i).getAutor() + ";");
					printW.print(libros.get(i).getTitulo() + ";");
					printW.print(libros.get(i).getEditorial() + ";");
					printW.print(libros.get(i).getPaginas() + ";");
					printW.print(libros.get(i).getAltura() + ";");
					printW.print(libros.get(i).getNotas() + ";");
					printW.print(libros.get(i).getIsbn() + ";");
					printW.println(libros.get(i).getMaterias());
				}
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Hubo un error a la hora de generar el fichero.");
		}
	}
	
	public void escribirXml(ArrayList<Libro> libros) {
		FileWriter fichero = null;
		String ruta = elegirCarpeta();
		
		try {
			fichero = new FileWriter(ruta + "\\Catalogo Exportado.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fichero != null) {
			BufferedWriter writer = new BufferedWriter(fichero);
			PrintWriter printW = new PrintWriter(writer);
			try {
				printW.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				printW.println("<biblioteca>");
				for (int i=0;i<libros.size();i++) {
					printW.println("\t<libro>");
					printW.println("\t\t<autor>" + libros.get(i).getAutor() + "</autor>");
					printW.println("\t\t<titulo>" + libros.get(i).getTitulo() + "</titulo>");
					printW.println("\t\t<editorial>" + libros.get(i).getEditorial() + "</editorial>");
					printW.println("\t\t<paginas>" + libros.get(i).getPaginas() + "</paginas>");
					printW.println("\t\t<altura>" + libros.get(i).getAltura() + "</altura>");
					printW.println("\t\t<notas>" + libros.get(i).getNotas() + "</notas>");
					printW.println("\t\t<isbn>" + libros.get(i).getIsbn() + "</isbn>");
					printW.println("\t\t<materias>" + libros.get(i).getMaterias() + "</materias>");
					printW.println("\t</libro>");
				}
				printW.println("</biblioteca>");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Hubo un error a la hora de generar el fichero.");
		}
	}
	
	public String elegirCarpeta() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		fileChooser.showDialog(null, "Seleccionar");
		
		System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
		
		return fileChooser.getSelectedFile().getAbsolutePath();
	}
}
