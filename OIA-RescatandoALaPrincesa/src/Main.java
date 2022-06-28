
public class Main {

	public static void main(String[] args) {
		String path = "rescate";
		GestorArchivos archivo = new GestorArchivos(path);
		Grafo grafo = archivo.leerArchivo();
		System.out.println(grafo.caminoDijkstra());
		
	}
	
}
