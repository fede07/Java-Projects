import java.io.FileWriter;
import java.io.PrintWriter;

public class Ejercicio06Test {
	
	public static void main(String[] args) {
		escribirArch();
	}
	
	
	public static void escribirArch() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		int cantPalabras = 250;
	
		try {
			fichero = new FileWriter("caso_maximo.in");
			pw = new PrintWriter(fichero);
			
			pw.println(cantPalabras);
			
			for(int i = 0; i<cantPalabras;i++)
			{
				pw.println("ananaanana");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
	
}
