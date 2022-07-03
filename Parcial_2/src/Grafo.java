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
		boolean visitado[] = new boolean[cantNodos + 1];
		distancias = new int[cantNodos + 1];
		for (int i = 0; i <= cantNodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			visitado[i] = false;
		}

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
}
