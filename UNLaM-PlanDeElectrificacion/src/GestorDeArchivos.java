import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeArchivos {

	String path;

	GestorDeArchivos(String path) {
		this.path = path;
	}

	Grafo leerArchivo() {
		try {
			Scanner scanner = new Scanner(new File(path + ".in"));
			int cantNodos = scanner.nextInt();
			int cantCentrales = scanner.nextInt();

			boolean conLuz[] = new boolean[cantNodos+1];

			for (int i = 0; i < cantCentrales; i++) {
				conLuz[scanner.nextInt()] = true;
			}

			int[][] matrizAdjacencia = new int[cantNodos][cantNodos];

			for (int i = 0; i < cantNodos; i++) {
				for (int j = 0; j < cantNodos; j++) {
					matrizAdjacencia[i][j] = scanner.nextInt();
				}
			}

			Grafo grafo = new Grafo(cantNodos, cantCentrales, conLuz);
			grafo.setMatrizAdjacencia(matrizAdjacencia);
			
			System.out.println("Fin lectura de archivo");
			return grafo;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	void escribirArchivo(int peso, ArrayList<Conexion> conexionesFinales) {
		try {
			FileWriter archivo = new FileWriter(path +".out");
			PrintWriter output = new PrintWriter(archivo);
			
			output.println(peso);
			for(Conexion c : conexionesFinales) {
				output.print(c.getSalida()+" ");
				output.println(c.getDestino());
			}
			
			output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
