package principal;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Grafo {

	private int cantNodos;
	private ArrayList<Nodo> nodos;
	private int[][] matrizAdj;
	
	public Grafo(int cantNodos, ArrayList<Nodo> listaNodos) {
	
		this.cantNodos = cantNodos;
		this.nodos = listaNodos;
		
		listaToMatriz();
		
	}
	
	public int bsf() {
		PriorityQueue<Nodo> nodoPQ = new PriorityQueue<Nodo>();
		boolean[] visitados = new boolean[cantNodos];
		boolean terminado = false;
		int nodosEnCapa = 1;
		int nodosEnProximaCapa = 0;
		int arbolesRecorridos = 0;
		
		visitados[0] = true;
		
		Nodo inicial = nodos.get(0);
		Nodo ultimo = nodos.get(cantNodos-1);
		
		nodoPQ.add(inicial);
		
		while(!nodoPQ.isEmpty()) {
			
			Nodo actual = nodoPQ.poll();
			
			if(actual.comparar(ultimo)) {
				terminado = true;
				break;
			}
			
			for(int i = 0; i<cantNodos;i++) {
				
				int distancia = matrizAdj[actual.getId()-1][i];
				
				if(distancia <= 100 && !visitados[i]) {
					if(distancia <=50 ) {
						nodoPQ.add(nodos.get(i));
						nodosEnProximaCapa++;
						visitados[i] = true;
					}else {
						nodos.get(i).setPrioridad(-1);
						nodoPQ.add(nodos.get(i));
						visitados[i] = true;
					}
				}
				
			}
			
			nodosEnCapa--;
			
			if(nodosEnCapa == 0) {
				nodosEnCapa = nodosEnProximaCapa;
				nodosEnProximaCapa = 0;
				arbolesRecorridos++;
			}
			
			if(terminado) {
				return arbolesRecorridos;
			}
			
		}
		
		return -1;
		
		
	}
	
	
	
	private void listaToMatriz() {
		
		matrizAdj = new int[cantNodos][cantNodos];
		
		for(int i =0; i<cantNodos; i++) {
			for(int j = 0; j<cantNodos;j++) {
				
				matrizAdj[i][j] = (int) nodos.get(i).distanciaA(nodos.get(j));
			}
		}
	}
	
}
