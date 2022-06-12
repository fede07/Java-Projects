import java.time.Instant;

public class Main {
	
	public static void main(String[] args) {
		Instant inst1 =  Instant.now();
		System.out.println(inst1);
		GestorArchivos archivo = new GestorArchivos("rapigrama");
		Jueguito test = new Jueguito(archivo);
		archivo.leerArchivo();
		test.jugar();
		System.out.println("JUGAR");
		inst1 =  Instant.now();
		System.out.println(inst1);
		System.out.print(test.getResultado());
		archivo.escribirArchivo(test.getResultado());
	}
}