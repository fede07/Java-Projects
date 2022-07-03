
public class Main {
	public static void main(String[] args) {
		GestorArchivos archivo = new GestorArchivos("arbol");
		Arbol arbol = archivo.leerArchivo();
		arbol.analizarArbol();
		archivo.escribirArchivo(arbol);
	}
}
