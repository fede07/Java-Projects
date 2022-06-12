package unlam.progava.oia;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeArchivos {
	
	private int cantAventureros;
	private ArrayList<Integer>movimientos = new ArrayList<Integer>();
	private String path;
	
	GestorDeArchivos(String path){
		this.path = path;
	}
	
	public void leerArchivo() {
		try {
			
			Scanner refarch = new Scanner(new File(path));
			
			cantAventureros = refarch.nextInt();
			
			while(refarch.hasNextInt()) {
				movimientos.add(refarch.nextInt());
			}
			
			refarch.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void escribirArchivo(String path, int ganador, ArrayList<Aventurero> eliminados) {
		try {
			
			FileWriter archivo = new FileWriter(path);
			
			PrintWriter printer = new PrintWriter(archivo);
			
			for (Aventurero aventurero : eliminados) {
				printer.print(aventurero.getNumero() + " ");
			}
			
			printer.println();
			
			printer.println(ganador);
			
			archivo.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getCantAventureros() {
		return cantAventureros;
	}

	public ArrayList<Integer> getMovimientos() {
		return movimientos;
	}

}
