package reto0Grupo6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class LeerFicheros {

	public ArrayList<Libro> leerFicheroTXT(ArrayList<Libro> libros) {
		File fichero = elegirFichero("txt");
		String linea = "";
		String dato = "";
		String valor = "";
		Libro libro = null;
		if (fichero != null) {
			try {
				BufferedReader br;
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));
					
					try {
						while ((linea = br.readLine()) != null) {
							if (!linea.equals("")) {
								StringTokenizer st = new StringTokenizer(linea, ":");
								while (st.hasMoreTokens()) {
									dato = st.nextToken();
									if (st.hasMoreTokens())
										valor = st.nextToken().substring(1);
									else 
										valor = "";
									switch (dato) {
										case "Autor":
											libro = new Libro();
											libro.setAutor(valor);
											break;
										case "Título":
											libro.setTitulo(valor);
											break;
										case "Editorial":
											libro.setEditorial(valor);
											break;
										case "Páginas":
											if (!valor.contentEquals(""))
												libro.setPaginas(Integer.parseInt(valor.replaceAll("\\s+", "")));
											break;
										case "Altura":
											if (!valor.contentEquals(""))
												libro.setAltura(Integer.parseInt(valor.replaceAll("\\s+", "")));
											break;
										case "Notas":
											libro.setNotas(valor);
											break;
										case "ISBN":
											libro.setIsbn(valor);
											break;
										case "Materias":
											libro.setMaterias(valor);
											libros.add(libro);
											break;
									}
									
								}
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return libros;
	}

	public ArrayList<Libro> leerFicheroCSV(ArrayList<Libro> libros) {
		File fichero = elegirFichero("csv");
		if (fichero != null) {
			final String SEPARADOR = ";";
			Libro libro = null;
	
			BufferedReader bufferLectura = null;
			try {
				// Abrir el .csv en buffer de lectura
				try {
					bufferLectura = new BufferedReader(new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				// Leer una linea del archivo
				String linea = null;
				try {
					linea = bufferLectura.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				while (linea != null) {
					// Sepapar la linea leida con el separador definido previamente
					String[] campos = linea.split(SEPARADOR, -1); // opción -1 para que siempre sea un array de 8 aunque los últimos campos estén vacíos
	
					if (!campos[0].equals("Autor")) {
						libro = new Libro();
						libro.setAutor(campos[0]);
						libro.setTitulo(campos[1]);
						libro.setEditorial(campos[2]);
						if(!campos[3].equals("")) {
								libro.setPaginas(Integer.parseInt(campos[3].replaceAll("\\s+", "")));
						}
						if(!campos[4].equals("")) {
							libro.setAltura(Integer.parseInt(campos[4].replaceAll("\\s+", "")));
						}
						libro.setNotas(campos[5]);
						libro.setIsbn(campos[6]);
						libro.setMaterias(campos[7]);
					}
					if (libro != null) {
						libros.add(libro);
					}
					// Volver a leer otra línea del fichero
					try {
						linea = bufferLectura.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException fnE) {
				System.out.println("Asegúrese de que la ruta de acceso al fichero .csv exista y sea correcta.");
			} finally {
				// Cierro el buffer de lectura
				if (bufferLectura != null) {
					try {
						bufferLectura.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return libros;
	}
	
	public ArrayList<Libro> leerFicheroXML(ArrayList<Libro> libros) {		
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
				
		File fichero = elegirFichero("xml");
		if (fichero != null) {
		    try {
		        SAXParser saxParser = saxParserFactory.newSAXParser();
		        XMLHandler handler = new XMLHandler();
		        saxParser.parse(fichero, handler);
		        
		        ArrayList<Libro> librosXML = handler.librosXML();
		        
		        for(Libro libro : librosXML)
		            System.out.println(libro.toString());
		        
		        libros.addAll(librosXML);
		        
		    } catch (ParserConfigurationException | SAXException | IOException e) {
		        e.printStackTrace();
		    }
		}
		return libros;
	}
	
	public File elegirFichero(String extension) {
		FileNameExtensionFilter filter = null;
		
		JFileChooser fileChooser = new JFileChooser();
		switch (extension) {
			case "txt": filter = new FileNameExtensionFilter("Archivo de texto", "txt"); break;
			case "csv": filter = new FileNameExtensionFilter("Archivo CSV", "csv"); break;
			case "xml": filter = new FileNameExtensionFilter("Archivo XML", "xml"); break;
			default: filter = new FileNameExtensionFilter("Archivo de texto", "txt");
		}
		
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.showDialog(null, "Abrir");
		
		if (fileChooser.getSelectedFile() != null)
			return fileChooser.getSelectedFile();
		else
			return null;
	}

}
