package metro;

import grafo.Grafo;

public class Main {
	
	public static void main(String[] args) {
		String path ="ambasConexionesSiemprePosibles";
		Grafo mapa;
		GestorArchivos gestor = new GestorArchivos(path);
		int resultado;
		gestor.leerArchivo();
		mapa = gestor.getMapa();
		resultado = mapa.pesoMinimoKruskal();
		gestor.escribirArchivo(resultado);
		System.out.println("Archivo Generado");
	}
}
