import java.util.LinkedList;
import java.util.PriorityQueue;

public class Grafo {
	private int[][] matAdj;
	private int cantNodos;
	private int[] distancias;
	
	Grafo(int[][] matAdj, int cantNodos){
		this.matAdj = matAdj;
		this.cantNodos = cantNodos;
	}
	
	public int[] dijkstra(int inicio) {
		boolean visitado[] = new boolean[cantNodos];
		distancias = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			visitado[i] = false;
		}
		
		inicio = inicio-1;
		distancias[inicio] = 0;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(inicio, distancias[inicio]));

		while (!pq.isEmpty()) {
			Nodo actual = pq.poll();
			visitado[actual.getID()] = true;

			if (distancias[actual.getID()] < actual.getDistancia()) {
				continue;
			}

			for (int vecino = 0; vecino < cantNodos; vecino++) {
				int pesoVecino = matAdj[actual.getID()][vecino];
				if (pesoVecino > 0) { 
					if (!visitado[vecino]) {
						int nuevaDist = distancias[actual.getID()] + pesoVecino;
						if (nuevaDist < distancias[vecino])
						distancias[vecino] = nuevaDist;
						pq.add(new Nodo(vecino, nuevaDist));
					}
				}
			}

		}

		return distancias;
	}
	
	public boolean[] bfsInterno(int inicio) {
		LinkedList<Integer> nodoCola = new LinkedList<Integer>();
		boolean[] visitados = new boolean[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			visitados[i] = false;
		}

		nodoCola.add(inicio);

		while (!nodoCola.isEmpty()) {
			int nodo = nodoCola.poll();
			visitados[nodo] = true;
			int[] vecinos = matAdj[nodo];

			for (int i = 0; i < cantNodos; i++) {
				if (!visitados[i] && vecinos[i] > 0) {
					nodoCola.add(vecinos[i]);
					visitados[i] = true;
				}
			}

		}

		return visitados;
	}
}
