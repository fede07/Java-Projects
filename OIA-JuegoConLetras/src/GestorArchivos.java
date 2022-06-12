import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestorArchivos {

	private String path;
	private Map<Character, ArrayList<Coordenada>> iniciales;
	private ArrayList<String> palabras;
	private char[][] letras;

	GestorArchivos(String path) {
		this.path = path;
	}

	public void leerArchivo() {
		try {
			Scanner refarch = new Scanner(new File(path + ".in"));
			int tamMatriz = refarch.nextInt();
			int cantPalabras = refarch.nextInt();
			iniciales = new HashMap<Character, ArrayList<Coordenada>>();

			letras = new char[tamMatriz][tamMatriz];
			for (int i = 0; i < tamMatriz; i++) {
				String fila = refarch.next();
				for (int j = 0; j < fila.length(); j++) {
					letras[i][j] = fila.charAt(j);
					if (iniciales.containsKey(letras[i][j])) {
						iniciales.get(letras[i][j]).add(new Coordenada(i, j));
					} else {
						iniciales.put(letras[i][j], new ArrayList<Coordenada>());
						iniciales.get(letras[i][j]).add(new Coordenada(i, j));
					}
				}
			} // ESTE FOR MAX 10K
			palabras = new ArrayList<String>();
			for (int i = 0; i < cantPalabras; i++) {
				String palabra = refarch.next();
				palabras.add(palabra);
			} // ESTE FOR MAX 10k
			refarch.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void escribirArchivo(ArrayList<String> resultado) {
		try {
			FileWriter output = new FileWriter(path +".out");
			PrintWriter print_output = new PrintWriter(output);
			
			for (String palabra : resultado) {
				print_output.println(palabra);
			}
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public Map<Character, ArrayList<Coordenada>> getIniciales() {
		return iniciales;
	}
	
	public ArrayList<String> getPalabras() {
		return palabras;
	}
	
	public char[][] getLetras() {
		return letras;
	}

	public void setPath(String path) {
		this.path = path;
	}

}