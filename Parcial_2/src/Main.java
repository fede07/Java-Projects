
public class Main {
	public static void main(String[] args) {
		GestorArchivos archivo = new GestorArchivos("caso7");
		Arbol arbol = archivo.leerArchivo();
		arbol.analizarArbol();
		archivo.escribirArchivo(arbol);
		System.out.println("FIN");
	}
}
