import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Procesador {
	
	Procesador(){
		
	}
	
	public int procesar(String texto, String prueba) {
		
		String arrayTexto[] = texto.split("");
		List<String> listaTexto = new ArrayList<String>();
		listaTexto.addAll(Arrays.asList(arrayTexto));
		
		String arrayPrueba[] = prueba.split("");
		List<String> listaPrueba = new ArrayList<String>();
		listaPrueba.addAll(Arrays.asList(arrayPrueba));
		
		int comienzo = 0;
		int index = 0;
		int movimientos = 0;
		
		for (String letra : listaTexto) {
			
			index = indexDe(comienzo, listaPrueba, letra);
			listaPrueba.add(comienzo, listaPrueba.get(index));
			listaPrueba.remove(index+1);
			movimientos+=index-comienzo;
			comienzo++;
		}
		
		return movimientos;
	}
	
	private int indexDe(int comienzo, List<String> lista, String letra) {
		
		int index = comienzo;
		
		while(index < lista.size() && (lista.get(index).compareTo(letra) != 0)) {
			index++;
		}
		
		if(index == lista.size()) {
			return -1;
		}
		
		return index;
	}
	
}
