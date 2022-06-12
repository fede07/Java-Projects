import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) {
		
		String ruta = "torneo.in";
		
		try {
			GestorArchivos.crearTorneo(ruta);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
