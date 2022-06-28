package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivos {
	
	private String path;
	private ArrayList<Movil> arrayMoviles;
	private int emergencia;
	
	public GestorArchivos(String path) {
		
		this.path = path;
	}
	
	public Grafo leerArchivo() {
		
		try {
			Scanner scanner = new Scanner(new File(path+".in"));
			
			int estaciones = scanner.nextInt();
			int tuneles = scanner.nextInt();
			int moviles = scanner.nextInt();
			
			int matAdj[][] = new int[estaciones][estaciones];
			
			for(int i = 0; i<tuneles;i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				matAdj[x-1][y-1] = 1;
			}
			
			arrayMoviles = new ArrayList<Movil>();
			for(int i = 0; i<moviles;i++) {
				Movil movil = new Movil(scanner.nextInt());
				arrayMoviles.add(movil);
			}
			emergencia = scanner.nextInt();
			
			Grafo grafo = new Grafo(estaciones, matAdj);
			
			scanner.close();
			
			return grafo;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<Movil> getArrayMoviles() {
		return arrayMoviles;
	}

	public int getEmergencia() {
		return emergencia;
	}
	
	
}
