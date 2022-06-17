package metro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import grafoKruskal.Grafo;

public class GestorArchivos {

	private String path;
	private int islas;
	private int puentes;
	private int tuneles;
	private Grafo mapa;
	
	GestorArchivos(String path){
		this.path = path;
	}
	
	public void leerArchivo() {
		
		try {
			
			Scanner refarch = new Scanner(new File(path + ".in"));
			
			islas = refarch.nextInt();
			
			tuneles = refarch.nextInt();
			puentes = refarch.nextInt();
			mapa = new Grafo(islas, tuneles+puentes);
			
			for(int i = 0; i<tuneles; i++) {
				int salida = refarch.nextInt();
				int destino = refarch.nextInt();
				mapa.agregarBorde(i, salida, destino, 0);
			}
			
			for(int i = 0; i<puentes; i++) {
				int salida = refarch.nextInt();
				int destino = refarch.nextInt();
				mapa.agregarBorde(i + tuneles, salida, destino, 1);
			}
			
			refarch.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void escribirArchivo() {
		try {
			FileWriter archivo = new FileWriter(path + ".out");
			PrintWriter printer = new PrintWriter(archivo);
			
			int resultado = mapa.kruskalMST();
			
			printer.println(resultado);
			
			printer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Grafo getMapa() {
		return mapa;
	}
}
