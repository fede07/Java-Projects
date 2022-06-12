import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestorArchivos {
	
	static Torneo crearTorneo(String archivo) throws FileNotFoundException {
		
		Scanner rarch = new Scanner(new File(archivo));
		Torneo torneo = new Torneo(rarch.nextInt());
		
		while(rarch.hasNextLine()) {
			Luchador luchador = new Luchador(rarch.nextInt(), rarch.nextInt());
			torneo.agregarLuchador(luchador);
		}
		
		return torneo;
	}
}
