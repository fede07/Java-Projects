import java.util.ArrayList;
import java.util.Map;

public class Jueguito {

	private GestorArchivos archivo;
	private ArrayList<String> resultado = new ArrayList<String>();

	Jueguito(GestorArchivos archivo) {
		this.archivo = archivo;
	}

	public void jugar() {
		Map<Character, ArrayList<Coordenada>> mapa = archivo.getIniciales();
		int numeroPalabra = 1;
		for (String palabra : archivo.getPalabras()) { // Max 10k
			char inicial = palabra.charAt(0);
			if(mapa.containsKey(inicial)) { // max 26
				char direccion = 'X';
				direccion = buscarPalabra(palabra,mapa.get(inicial).get(0),direccion);
				int i=1;
				while(direccion == 'X' && i < mapa.get(inicial).size()) { // Max 10k
					direccion = buscarPalabra(palabra,mapa.get(inicial).get(i),direccion);
					i++;
				}
				if(direccion !='X') {
					resultado.add(numeroPalabra + " " + direccion);
				}	
				}
			numeroPalabra++;
			}
			
		}


	private char buscarPalabra(String palabra, Coordenada coordeanda, char direccion) {
		int fil=coordeanda.getFil();
		int col=coordeanda.getCol();
		if (buscarEste(fil,col,0,palabra)) {
			direccion = 'E';
		}else if (buscarSur(fil,col,0,palabra)) {
			direccion = 'S';
		}else if (buscarOeste(fil,col,0,palabra)) {
			direccion = 'O';
		}else if (buscarNorte(fil,col,0,palabra)) {
			direccion = 'N';
		}
		return direccion;
	}
	private boolean buscarEste(int fil, int col, int indice, String palabra) {
		char[][] letras = archivo.getLetras();
		if(indice == palabra.length()-1 && letras[fil][col]==palabra.charAt(indice)) {
			return true;
		}
		if( col < letras.length-1 && letras[fil][col]==palabra.charAt(indice)) {
			return buscarEste(fil,col+1,indice+1,palabra);
		}
		return false;
	}
	private boolean buscarSur(int fil, int col, int indice, String palabra) {
		char[][] letras = archivo.getLetras();
		if(indice == palabra.length()-1 && letras[fil][col]==palabra.charAt(indice)) {
			return true;
		}
		if( fil < letras.length-1 && letras[fil][col]==palabra.charAt(indice)) {
			return buscarSur(fil+1,col,indice+1,palabra);
		}
		return false;
	}
	private boolean buscarOeste(int fil, int col, int indice, String palabra) {
		char[][] letras = archivo.getLetras();
		if(indice == palabra.length()-1 && letras[fil][col]==palabra.charAt(indice)) {
			return true;
		}
		if( col >= 0  && letras[fil][col]==palabra.charAt(indice)) {
			return buscarOeste(fil,col-1,indice+1,palabra);
		}
		return false;
	}
	private boolean buscarNorte(int fil, int col, int indice, String palabra) {
		char[][] letras = archivo.getLetras();
		if(indice == palabra.length()-1 && letras[fil][col]==palabra.charAt(indice)) {
			return true;
		}
		if(fil >= 0 && letras[fil][col]==palabra.charAt(indice)) {
			return buscarNorte(fil-1,col,indice+1,palabra);
		}
		return false;
	}
	
	public ArrayList<String> getResultado() {
		return resultado;
	}
}