package metro;

import java.io.File;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Grafo getMapa() {
		return mapa;
	}
}
