package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivos {
	
	private String path;
	
	public GestorArchivos(String path) {
		
		this.path = path;
	}
	
	public Grafo leerArchivo() {
		
		try {
			Scanner scanner = new Scanner(new File(path+".in"));
			
			int cantNodos = 0;
			
			ArrayList<Nodo> nodos = new ArrayList<Nodo>();
			
			while(scanner.hasNextLine()) {
				cantNodos++;
				
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				nodos.add(new Nodo(cantNodos, x, y));
			}
			
			Grafo grafo = new Grafo(cantNodos, nodos);
			
			scanner.close();
			
			return grafo;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
