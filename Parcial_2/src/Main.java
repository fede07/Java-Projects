
public class Main {
	public static void main(String[] args) {
		GestorArchivos archivo = new GestorArchivos("arbol1");
		Arbol arbol = archivo.leerArchivo();
		arbol.analizarArbol();
		archivo.escribirArchivo(arbol);
	}
}
