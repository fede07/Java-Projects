import java.io.FileWriter;
import java.io.PrintWriter;

public class Testing {
	
	public static void main(String[] args) {
		escribirArch();
	}

	public static void escribirArch() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		int cantVend = 100;
		int randMaxVent = 1000;
		int randMinVent = 1000;
		int randMaxPrecio = 5000;
		int randMinPrecio = 5000;
		int ventasConsecutivas = 1000;
	
		try {
			fichero = new FileWriter("premio.in");
			pw = new PrintWriter(fichero);
			
			pw.println(cantVend);
			for(int i = 0;i<cantVend;i++) {
				int randomVentas = (int)Math.floor(Math.random()*(randMaxVent-randMinVent+1)+randMinVent);
				pw.println(randomVentas);
				for(int j = 0; j<randomVentas;j++) {
					int randomPrecio = (int) Math.floor(Math.random()*(randMaxPrecio-randMinPrecio+1)+randMinPrecio);
					pw.println(randomPrecio);
				}
					
			}
			
			pw.println(ventasConsecutivas);
			
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
