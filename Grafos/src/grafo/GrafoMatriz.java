package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GrafoMatriz extends Grafo {

	private int[][] matrizAdj;
	private int cantNodos;
	private int[] padresArray;
	private int[] distancias;
	private int padresKruskal[];
	private ArrayList<Nodo> nodos;
	private PriorityQueue<Conexion> conexionesLista;
	private boolean visitadosDFS[];
	private int cantSubgrafos;
	private int[] subGrafos;
	private int pesoMinimoKruskal;
	private int conexionesMax;

	public GrafoMatriz(int[][] matrizAdj, int cantNodos) {

		this.matrizAdj = matrizAdj;
		this.cantNodos = cantNodos;

	}

	@Override
	public ArrayList<Integer> bfs(int inicio) {
		LinkedList<Integer> nodoCola = new LinkedList<Integer>();
		boolean[] visitados = new boolean[cantNodos];
		ArrayList<Integer> recorrido = new ArrayList<Integer>();

		for (int i = 0; i < cantNodos; i++) {
			visitados[i] = false;
		}

		nodoCola.add(inicio);
		visitados[0] = true;

		while (!nodoCola.isEmpty()) {
			int nodo = nodoCola.poll();
			int[] vecinos = matrizAdj[nodo];

			for (int i = 0; i < cantNodos; i++) {
				if (!visitados[i] && vecinos[i] > 0) {
					nodoCola.add(vecinos[i]);
					visitados[i] = true;
					recorrido.add(nodo);
				}
			}

		}

		Collections.reverse(recorrido);

		return recorrido;
	}

	public int bfsGrid() {
		PriorityQueue<Nodo> nodoPQ = new PriorityQueue<Nodo>();
		ArrayList<Integer> recorrido = new ArrayList<Integer>();
		boolean[] visitados = new boolean[cantNodos];
		boolean terminado = false;
		int nodosEnCapa = 1;
		int nodosEnProximaCapa = 0;
		int recorridos = 0;

		if (nodos == null) {
			crearListaNodos();
		}

		visitados[0] = true;

		Nodo inicial = nodos.get(0);
		Nodo ultimo = nodos.get(cantNodos - 1);

		nodoPQ.add(inicial);

		while (!nodoPQ.isEmpty()) {

			Nodo actual = nodoPQ.poll();

			if (actual.comparar(ultimo)) {
				terminado = true;
				break;
			}

			for (int i = 0; i < cantNodos; i++) {

				if (!visitados[i]) {
					nodoPQ.add(nodos.get(i));
					nodosEnProximaCapa++;
					visitados[i] = true;
				}
			}

			nodosEnCapa--;

			if (nodosEnCapa == 0) {
				nodosEnCapa = nodosEnProximaCapa;
				nodosEnProximaCapa = 0;
				recorridos++;
				recorrido.add(actual.getID());
			}

			if (terminado) {
				return recorridos;
			}

		}

		return -1;
	}

	@Override
	public void dfs(int inicio) {

		visitadosDFS = new boolean[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			visitadosDFS[i] = false;
		}
		dfsCiclo(inicio);
	}

	private void dfsCiclo(int inicio) {

		if (visitadosDFS[inicio - 1]) {
			return;
		}

		visitadosDFS[inicio - 1] = true;
		subGrafos[inicio] = cantSubgrafos;
		
		int[] vecinos = nodos.get(inicio).getArrayAdj();
		for (int i = 0; i < cantNodos; i++) {
			if (vecinos[i] > 0) {
				dfsCiclo(vecinos[i]);
			}
		}
	}
	
	public int buscarSubgrafos() {
		
		for (int i = 0; i < visitadosDFS.length; i++) {
			visitadosDFS[i]= false;
		}
		
		cantSubgrafos = 0;
		
		for (int i=0;i<cantNodos;i++) {
			if(!visitadosDFS[i]) {
				cantSubgrafos++;
				dfs(i);
			}
		}
		
		return cantSubgrafos;
	}

	public int[] dijkstra(int inicio, int fin) {

		if (distancias != null) {
			return distancias;
		}

		boolean visitado[] = new boolean[cantNodos + 1];
		padresArray = new int[cantNodos + 1];
		distancias = new int[cantNodos + 1];
		for (int i = 0; i <= cantNodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padresArray[i] = -1;
			visitado[i] = false;
		}

		distancias[inicio] = 0;
		padresArray[inicio] = -1;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(inicio, distancias[inicio]));

		while (!pq.isEmpty()) {
			Nodo actual = pq.poll();
			visitado[actual.getID()] = true;

			if (distancias[actual.getID()] < actual.getDistancia()) {
				continue;
			}

			for (int vecino = 0; vecino < cantNodos; vecino++) {
				int pesoVecino = matrizAdj[actual.getID()][vecino];
				if (pesoVecino > 0) {
					if (!visitado[vecino]) {
						int nuevaDist = distancias[actual.getID()] + pesoVecino;
						distancias[vecino] = nuevaDist;
						pq.add(new Nodo(vecino, nuevaDist));
						padresArray[vecino] = actual.getID();
					}
				}
			}
			if (actual.getID() == fin) {
				return distancias;
			}
		}
		return null;
	}

	@Override
	public int[] dijkstra(int inicio) {
		boolean visitado[] = new boolean[cantNodos + 1];
		padresArray = new int[cantNodos + 1];
		distancias = new int[cantNodos + 1];
		for (int i = 0; i <= cantNodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padresArray[i] = -1;
			visitado[i] = false;
		}

		distancias[inicio] = 0;
		padresArray[inicio] = -1;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(inicio, distancias[inicio]));

		while (!pq.isEmpty()) {
			Nodo actual = pq.poll();
			visitado[actual.getID()] = true;

			if (distancias[actual.getID()] < actual.getDistancia()) {
				continue;
			}

			for (int vecino = 0; vecino < cantNodos; vecino++) {
				int pesoVecino = matrizAdj[actual.getID()][vecino];
				if (pesoVecino > 0) {
					if (!visitado[vecino]) {
						int nuevaDist = distancias[actual.getID()] + pesoVecino;
						distancias[vecino] = nuevaDist;
						pq.add(new Nodo(vecino, nuevaDist));
						padresArray[vecino] = actual.getID();
					}
				}
			}

		}

		return distancias;
	}

	public ArrayList<Integer> caminoDijkstra(int nodoInicial, int nodoFinal) {

		ArrayList<Integer> camino = new ArrayList<Integer>();

		if (distancias == null) {
			dijkstra(nodoInicial, nodoFinal);
		}

		if (distancias[nodoInicial] == nodoFinal) {
			camino.add(0);
			return camino;
		}

		for (int actual = nodoFinal; actual != -1; actual = padresArray[actual]) {
			camino.add(actual);
		}

		Collections.reverse(camino);

		return camino;

	}

	public int kruskal() {
		conexionesLista = new PriorityQueue<Conexion>();

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				Conexion conexion = new Conexion(i + 1, j + 1, matrizAdj[i][j]);
				conexionesLista.add(conexion);
			}
		}

		padresKruskal = new int[cantNodos + 1];

		for (int i = 1; i <= cantNodos; i++) {
			padresKruskal[i] = i;
		}

		conexionesMax = 0;
		pesoMinimoKruskal = 0;

		while (!conexionesLista.isEmpty() && conexionesMax < cantNodos) {
			Conexion conexion = conexionesLista.poll();
			int padreSalida = buscarPadre(conexion.getSalida());
			int padreDestino = buscarPadre(conexion.getDestino());

			if (padreSalida != padreDestino) {
				padresKruskal[padreSalida] = padreDestino;
				conexionesMax++;
				pesoMinimoKruskal += conexion.getPeso();
			}

		}
		
		return pesoMinimoKruskal;

	}

	private int buscarPadre(int nodo) {

		if (padresKruskal[nodo] == nodo) {
			return nodo;
		}
		return buscarPadre(padresKruskal[nodo]);
	}

	private void crearListaNodos() {

		nodos = new ArrayList<Nodo>();

		for (int i = 0; i < cantNodos; i++) {
			Nodo nodo = new Nodo(i + 1, matrizAdj[i]);
			nodos.add(nodo);
		}
	}
}
