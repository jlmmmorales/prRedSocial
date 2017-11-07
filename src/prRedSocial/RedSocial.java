package prRedSocial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RedSocial {
	public static void main(String[] args) throws FileNotFoundException {
		String datos = "";
		try (Scanner linea = new Scanner(new File("redsocial.txt"))) {
			try (PrintWriter pw = new PrintWriter("copiaRedSocial.txt")){
				while (linea.hasNextLine()){
					datos = linea.nextLine();
					pw.println(datos);
					mostrarPorPantalla(datos);
				}
			} catch (FileNotFoundException e){
				System.err.println("No se ha encontrado el fichero.");
			}
		}
	}

	/**
	 * Muestra por pantalla el String con los datos de una manera correcta.
	 * @param datos
	 */
	private static void mostrarPorPantalla(String datos) {
		String nombre = "";
		String edad = "";
		String correo = "";
		String aficiones = "";
		String aficion = "";
		
		try (Scanner sc = new Scanner(datos)){
			sc.useDelimiter("[%]");
			if(sc.hasNext()){
				nombre = sc.next();
			}
			if(sc.hasNext()){
				edad = sc.next();
			}
			if(sc.hasNext()){
				correo = sc.next();
			}
			System.out.println("("+nombre+","+edad+","+correo+")");
			System.out.println("Aficiones:");
			if(sc.hasNext()){
				aficiones = sc.next();
				//Trato las aficiones con otro Scanner
				try (Scanner scAficiones = new Scanner(aficiones)){
					scAficiones.useDelimiter("[,]");
					while(scAficiones.hasNext()){
						aficion = scAficiones.next();
						System.out.println("     "+aficion);
					}
				}
			}
			
		}
		
	}
}