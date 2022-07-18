import java.util.ArrayList;

public class Grafo {
	
	private int matrizAdy[][];
	private int predecesores[];	
	private int nodoInicial;
	
	public Grafo(int matriz[][]) {
		this.matrizAdy = matriz;
		this.predecesores = new int[matrizAdy.length];		
	}
	
	public int hallarNodoMinDist(boolean[] conjSol, int[] dist) {
		int minKey = Integer.MAX_VALUE;
		int nodo = 0;
		
		for (int i = 0; i < matrizAdy.length; i++) {
			if (conjSol[i] == false && minKey > dist[i]) {
				minKey = dist[i];
				nodo = i;
			}
		}

		return nodo;
	}
	
	public int[] dijkstra(int nodoInicial) {

		boolean conjSol[] = new boolean[matrizAdy.length];

		int dist[] = new int[matrizAdy.length];
		int infinidad = Integer.MAX_VALUE;
		this.nodoInicial = nodoInicial;
		
		for (int i = 0; i < matrizAdy.length; i++) {
			dist[i] = infinidad;
			predecesores[i] = nodoInicial;
		}
		
		dist[nodoInicial] = 0;
		
		for (int i = 0; i < matrizAdy.length; i++) {
			int nodoActual = hallarNodoMinDist(conjSol, dist);

			conjSol[nodoActual] = true;

			for (int vecino = 0; vecino < matrizAdy.length; vecino++) {		
				if (matrizAdy[nodoActual][vecino] > 0) {
					if (conjSol[vecino] == false && matrizAdy[nodoActual][vecino] != infinidad) {
						int minimoTentativo = dist[nodoActual] + matrizAdy[nodoActual][vecino];
						
						if (minimoTentativo < dist[vecino])	{
							dist[vecino] = minimoTentativo;
							predecesores[vecino] = nodoActual;
						}
					}
				}
			}			
		}	
		return dist;
	}
	
	public ArrayList<Integer> getCamino(int nodoHasta) {
		int i = nodoHasta;
		ArrayList<Integer> camino = new ArrayList<Integer>();
		camino.add(i);
		
		while (i != nodoInicial) {
			i = predecesores[i];
			camino.add(i);
		}
		
		return camino;
	}
	
	public void eliminarDragones(int dragones[]) {
		for(int col: dragones) {
			for(int fila = 0; fila < matrizAdy.length; fila++ ) {
				matrizAdy[col-1][fila] = Integer.MAX_VALUE;
				matrizAdy[fila][col-1] = Integer.MAX_VALUE;
			}
		}
	}
	
}

