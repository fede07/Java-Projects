package metro;

public class Main {
	
	public static void main(String[] args) {
		String path ="metro";
		GestorArchivos gestor = new GestorArchivos(path);
		gestor.leerArchivo();
		gestor.escribirArchivo();
		
	}
}
