package metro;

import grafoKruskal.Grafo;

public class Main {
	
	public static void main(String[] args) {
		String path ="metro";
		GestorArchivos gestor = new GestorArchivos(path);
		gestor.leerArchivo();
		Grafo mapa = gestor.getMapa();
		
		System.out.println(mapa.kruskalMST());
		
	}
}
