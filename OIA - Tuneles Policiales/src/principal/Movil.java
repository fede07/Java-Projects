package principal;

import java.util.ArrayList;

public class Movil implements Comparable<Movil>{
	
	private int nodo;
	ArrayList<Integer> recorrido;
	int distancias[];
	int tiempo;
	
	Movil(int nodo){
		this.nodo = nodo;
	}

	public ArrayList<Integer> getRecorrido() {
		return recorrido;
	}

	public void crearRecorrido(int padres[]) {
		
		recorrido = new ArrayList<Integer>();
		recorrido.add(nodo);
		
		for(int i = 1; i<=padres.length;i++) {
			if(padres[i]<Integer.MAX_VALUE-1000) {
				recorrido.add(padres[i]);
			}
		}
		
	}

	public int getNodo() {
		return nodo;
	}

	public int[] getDistancias() {
		return distancias;
	}

	public void setDistancias(int[] distancias) {
		this.distancias = distancias;

		
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int nodo) {
		this.tiempo = distancias[nodo];
	}

	@Override
	public int compareTo(Movil o) {
		return this.tiempo - o.tiempo;
	}
	
	
	

}
