
public class Main {
	public static void main(String[] args) {
		GestorArchivos archivo = new GestorArchivos("DOOM");
		Arbol arbol = archivo.leerArchivo();
		arbol.analizarArbol();
		archivo.escribirArchivo(arbol);
		System.out.println("FIN");
	}
}
