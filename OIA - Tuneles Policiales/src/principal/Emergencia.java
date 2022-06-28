package principal;

import java.util.ArrayList;

public class Emergencia {
	
	private Grafo grafo;
	private int emergencia;
	private ArrayList<Movil> arrayMoviles;

	
	Emergencia(){
		GestorArchivos archivo = new GestorArchivos("TUNELES");
		grafo = archivo.leerArchivo();
		emergencia = archivo.getEmergencia();
		arrayMoviles = archivo.getArrayMoviles();
		
	}
	
	public void rescatar() {
		for(Movil movil : arrayMoviles) {
			movil.setDistancias(grafo.djikstraMismoPeso(movil.getNodo(), emergencia, arrayMoviles));
			movil.crearRecorrido(grafo.getPadres());
			movil.setTiempo(emergencia);
		}	
		
		arrayMoviles.sort(null);
		
		int tiempoMin = arrayMoviles.get(0).tiempo;
		int cantMin = 0;
		int tiempoAnt = 0;
		int cantAnt;
		int cantTotal = 0;
		
		while(cantTotal < 3 ) {
			
			
			
		}
		
		
	}

}
