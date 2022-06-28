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
	private ArrayList<Nodo> nodosLista;
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

	public int[] bfsInterno(int inicio) {
		LinkedList<Integer> nodoCola = new LinkedList<Integer>();
		boolean[] visitados = new boolean[cantNodos];
		int[] recorrido = new int[cantNodos + 1];

		for (int i = 0; i < cantNodos; i++) {
			visitados[i] = false;
			recorrido[i] = -1;
		}

		nodoCola.add(inicio);

		while (!nodoCola.isEmpty()) {
			int nodo = nodoCola.poll();
			visitados[nodo] = true;
			int[] vecinos = matrizAdj[nodo];

			for (int i = 0; i < cantNodos; i++) {
				if (!visitados[i] && vecinos[i] > 0) {
					nodoCola.add(vecinos[i]);
					visitados[i] = true;
					recorrido[i] = nodo;
				}
			}

		}

		return recorrido;
	}
	
	@Override
	public ArrayList<Integer> bfs(int start, int end) {
		
		int[] recorrido = bfsInterno(start);
		
		ArrayList<Integer> path = new ArrayList<>();
		for (int at = end; at != -1; at = recorrido[at]) {
			path.add(at);
		}
		Collections.reverse(path);
		if (path.get(0) == start)
			return path;
		
		path.clear();
		return path;
	}

	public int bfsGrid(int inicio) {
		PriorityQueue<Nodo> nodoPQ = new PriorityQueue<Nodo>();
		boolean[] visitados = new boolean[cantNodos+1];
		boolean terminado = false;
		int nodosEnCapa = 1;
		int nodosEnProximaCapa = 0;
		int recorridos = 0;

		if (nodosLista == null) {
			crearListaNodos();
		}

		Nodo inicial = nodosLista.get(inicio);
		Nodo ultimo = nodosLista.get(cantNodos - 1);

		nodoPQ.add(inicial);

		while (!nodoPQ.isEmpty()) {
			
			Nodo actual = nodoPQ.poll();

			visitados[actual.getID()] = true;
			
			if (actual.comparar(ultimo)) {
				terminado = true;
				break;
			}

//			for (int i = 0; i < cantNodos; i++) {
//
//				int vecino = matrizAdj[actual.getID()][i];
//				
//				if (vecino != 0 && !visitados[i]) {
//					nodoPQ.add(nodosLista.get(i));
//					nodosEnProximaCapa++;
//					visitados[i] = true;
//				}
//			}
//			
			for(int vecino : actual.getArrayAdj()) {
				
				if (vecino != 0 && !visitados[vecino]) {
					nodoPQ.add(nodosLista.get(vecino));
					nodosEnProximaCapa++;
					visitados[vecino] = true;
				}
				
			}

			nodosEnCapa--;

			if (nodosEnCapa == 0) {
				nodosEnCapa = nodosEnProximaCapa;
				nodosEnProximaCapa = 0;
				recorridos++;
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

		int[] vecinos = nodosLista.get(inicio).getArrayAdj();
		for (int i = 0; i < cantNodos; i++) {
			if (vecinos[i] > 0) {
				dfsCiclo(vecinos[i]);
			}
		}
	}

	public int buscarSubgrafos() {

		for (int i = 0; i < visitadosDFS.length; i++) {
			visitadosDFS[i] = false;
		}

		cantSubgrafos = 0;

		for (int i = 0; i < cantNodos; i++) {
			if (!visitadosDFS[i]) {
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

		nodosLista = new ArrayList<Nodo>();

		for (int i = 0; i < cantNodos; i++) {
			Nodo nodo = new Nodo(i + 1, matrizAdj[i]);
			nodosLista.add(nodo);
		}
	}
}
