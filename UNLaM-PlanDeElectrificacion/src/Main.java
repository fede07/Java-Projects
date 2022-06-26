
public class Main {

	public static void main(String[] args) {
		
		GestorDeArchivos archivo = new GestorDeArchivos("tendidoLargo");
		Grafo grafo = archivo.leerArchivo();
		int res = grafo.kruskalElectrico();
		archivo.escribirArchivo(res, grafo.getConexionesFinales());
	}
	
}
