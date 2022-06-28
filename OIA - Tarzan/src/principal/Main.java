package principal;

public class Main {
	
	public static void main(String[] args) {
		GestorArchivos archivo = new GestorArchivos("tarzan");
		Grafo grafo = archivo.leerArchivo();
		int res = grafo.bsf();
		System.out.println(res);
	}

}
