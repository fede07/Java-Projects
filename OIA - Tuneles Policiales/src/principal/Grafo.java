package principal;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Grafo {

	private int nodos;
	private int matAdj[][];
	private int[] padres;

	Grafo(int nodos, int matAdj[][]) {
		this.matAdj = matAdj;
		this.nodos = nodos;
	}

	public int[] djikstraMismoPeso(int inicio, int fin, ArrayList<Movil> arrayMoviles) {
		boolean visitado[] = new boolean[nodos + 1];
		padres = new int[nodos + 1];
		int distancias[] = new int[nodos + 1];
		for (int i = 0; i <= nodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padres[i] = -1;
			visitado[i] = false;
		}

		for (Movil movil : arrayMoviles) {
			visitado[movil.getNodo()] = true;
		}
		distancias[inicio] = 0;
		padres[inicio] = -1;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(inicio, distancias[inicio]));

		while (!pq.isEmpty()) {
			Nodo actual = pq.poll();
			visitado[actual.getNumero()] = true;

			if (distancias[actual.getNumero()] < actual.getDistancia()) {
				continue;
			}

			for (int vecino = 0; vecino < nodos; vecino++) {
				int pesoVecino = matAdj[actual.getNumero()][vecino];
				if (pesoVecino > 0) {
					if (!visitado[vecino]) {
						int nuevaDist = distancias[actual.getNumero()] + pesoVecino;
						distancias[vecino] = nuevaDist;
						pq.add(new Nodo(vecino, nuevaDist));
						padres[vecino] = actual.getNumero();
					}
				}
			}
			if (actual.getNumero() == fin) {
				return distancias;
			}
		}
		return null;
	}

	public int[] getPadres() {
		return padres;
	}

}
