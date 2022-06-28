import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Grafo {

	private int cantNodos;
	private int cantConexiones;
	private Map<Integer, ArrayList<Nodo>> listaAdj;
	private Map<Integer, Boolean> mapaDragones;
	private int[] padresArray;
	private int nodoInicial;
	private int nodoFinal;

	public Grafo(int cantNodos, int cantConexiones, Map<Integer, ArrayList<Nodo>> listaAdj, int nodoInicial,
			int nodoFinal) {

		this.cantNodos = cantNodos;
		this.cantConexiones = cantConexiones;
		this.listaAdj = listaAdj;
		this.nodoInicial = nodoInicial;
		this.nodoFinal = nodoFinal;
		

		padresArray = new int[cantNodos + 1];
	}
	
	public int[] dijkstraUnico() {

		int[] distancias = new int[cantNodos + 1];
		boolean[] visitadoArray = new boolean[cantNodos + 1];

		for (int i = 0; i<=cantNodos;i++) {
			distancias[i] = Integer.MAX_VALUE;
			padresArray[i] = -1;
			visitadoArray[i] = false;
		}

		distancias[nodoInicial] = 0;

		PriorityQueue<Nodo> nodos = new PriorityQueue<Nodo>();
		nodos.add(new Nodo(nodoInicial, distancias[nodoInicial]));

		while (!nodos.isEmpty()) {

			Nodo actual = nodos.poll();
			visitadoArray[actual.getNumero()] = true;

			if(distancias[actual.getNumero()] < actual.getDistancia()) {
				continue;
			}
			
			if(actual.getNumero() == nodoFinal) {
				return distancias;
			}
			
			ArrayList<Nodo> vecinos = listaAdj.get(actual.getNumero());
			
			for (Nodo vecino : vecinos) {

				if (!visitadoArray[vecino.getNumero()]) {

					int nuevaDistancia = distancias[actual.getNumero()] + vecino.getDistancia();
					if (distancias[vecino.getNumero()] > nuevaDistancia) {
						
						distancias[vecino.getNumero()] = nuevaDistancia;
						padresArray[vecino.getNumero()] = actual.getNumero();
						vecino.setDistancia(nuevaDistancia);
						nodos.add(vecino);

					}

				}

			}

		}

		return distancias;

	}

	public int[] dijkstraTodos() {

		int[] distancias = new int[cantNodos + 1];
		boolean[] visitadoArray = new boolean[cantNodos + 1];

		for (int i = 0; i<=cantNodos;i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padresArray[i] = -1;
			visitadoArray[i] = false;
		}

		distancias[nodoInicial] = 0;

		PriorityQueue<Nodo> nodos = new PriorityQueue<Nodo>();
		nodos.add(new Nodo(nodoInicial, distancias[nodoInicial]));

		while (!nodos.isEmpty()) {

			Nodo actual = nodos.poll();
			visitadoArray[actual.getNumero()] = true;

			if(distancias[actual.getNumero()] < actual.getDistancia()) {
				continue;
			}
			
			ArrayList<Nodo> vecinos = listaAdj.get(actual.getNumero());
			
			for (Nodo vecino : vecinos) {

				if (!visitadoArray[vecino.getNumero()]) {

					int nuevaDistancia = distancias[actual.getNumero()] + vecino.getDistancia();
					if (distancias[vecino.getNumero()] > nuevaDistancia) {
						
						distancias[vecino.getNumero()] = nuevaDistancia;
						padresArray[vecino.getNumero()] = actual.getNumero();
						vecino.setDistancia(nuevaDistancia);
						nodos.add(vecino);

					}

				}

			}

		}

		return distancias;
	}
	
	public int[] dijkstraMatriz() {

		int[] distancias = new int[cantNodos + 1];
		boolean[] visitadoArray = new boolean[cantNodos + 1];

		for (int i = 0; i<=cantNodos;i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padresArray[i] = -1;
			visitadoArray[i] = false;
		}

		distancias[nodoInicial] = 0;

		PriorityQueue<Nodo> nodos = new PriorityQueue<Nodo>();
		nodos.add(new Nodo(nodoInicial, distancias[nodoInicial]));

		while (!nodos.isEmpty()) {

			Nodo actual = nodos.poll();
			visitadoArray[actual.getNumero()] = true;

			if(distancias[actual.getNumero()] < actual.getDistancia()) {
				continue;
			}
			
			ArrayList<Nodo> vecinos = listaAdj.get(actual.getNumero());
			
			for (Nodo vecino : vecinos) {

				if (!visitadoArray[vecino.getNumero()]) {

					int nuevaDistancia = distancias[actual.getNumero()] + vecino.getDistancia();
					if (distancias[vecino.getNumero()] > nuevaDistancia) {
						
						distancias[vecino.getNumero()] = nuevaDistancia;
						padresArray[vecino.getNumero()] = actual.getNumero();
						vecino.setDistancia(nuevaDistancia);
						nodos.add(vecino);

					}

				}

			}

		}

		return distancias;
	}
	
	public ArrayList<Integer> caminoDijkstra(){
		
		ArrayList<Integer> camino = new ArrayList<Integer>();
		
		int[] distancias = dijkstraUnico();
		
		if(distancias[nodoInicial] == nodoFinal) {
			camino.add(0);
			return camino;
		}
		
		for(int actual = nodoFinal; actual!=-1; actual = padresArray[actual]) {
			camino.add(actual);
		}
		
		Collections.reverse(camino);
		
		return camino;
		
	}
	
	void eliminarDragones() {
		
		for (int dragones : mapaDragones.keySet()) {
			listaAdj.remove(dragones);
			
			for(Entry<Integer, ArrayList<Nodo>> vecinos : listaAdj.entrySet()) {
				
			}
			
		}
		
		
		
	}

	public void setMapaDragones(Map<Integer, Boolean> mapaDragones) {
		this.mapaDragones = mapaDragones;
	}

}
