import java.util.ArrayList;
import java.util.PriorityQueue;

public class Grafo {
	private int nodos;
	private int[][] matrizAdjacencia;
	private boolean[] conLuz;
	private int arrayReferencia[];
	private ArrayList<Conexion> conexionesFinales;

	public Grafo(int nodos, int centrales, boolean[] conLuz) {
		
		this.nodos = nodos;
		this.conLuz = conLuz;
		arrayReferencia = new int[nodos+1];
		
		for(int i = 1; i<=nodos;i++) {
			arrayReferencia[i] = i;
		}
		
		conexionesFinales = new ArrayList<Conexion>();
	}
	
	public int kruskalElectrico() {
		PriorityQueue<Conexion> conexiones = new PriorityQueue<Conexion>();
		
		for(int i = 0; i<nodos; i++) {
			for(int j = i+1; j<nodos; j++){
				Conexion conexion = new Conexion(i+1, j+1, matrizAdjacencia[i][j]);
				conexiones.add(conexion);
			}
		}
		
		int conexionesMax = 0;
		int pesoConexiones = 0;
		
		while(!conexiones.isEmpty() && conexionesMax < nodos) {
			Conexion conexion = conexiones.poll();
			int padreSalida = buscarPadre(conexion.getSalida());
			int padreDestino = buscarPadre(conexion.getDestino());
			
			if(padreSalida != padreDestino && !(conLuz[padreSalida] && conLuz[padreDestino])) {
				
				conLuz[padreSalida] = true;
				conLuz[padreDestino] = true;
				arrayReferencia[padreSalida] = padreDestino;
				conexionesFinales.add(conexion);
				conexionesMax++;
				pesoConexiones += conexion.getPeso();
			}
			
		}
		
		System.out.println("Fin");
		return pesoConexiones;	
	
	}
	
	public int kruskal() {
		PriorityQueue<Conexion> conexiones = new PriorityQueue<Conexion>();
		
		for(int i = 0; i<nodos; i++) {
			for(int j = i+1; j<nodos; j++){
				Conexion conexion = new Conexion(i+1, j+1, matrizAdjacencia[i][j]);
				conexiones.add(conexion);
			}
		}
		
		int conexionesMax = 0;
		int pesoConexiones = 0;
		
		while(!conexiones.isEmpty() && conexionesMax < nodos) {
			Conexion conexion = conexiones.poll();
			int padreSalida = buscarPadre(conexion.getSalida());
			int padreDestino = buscarPadre(conexion.getDestino());
			
			if(padreSalida != padreDestino) {
				arrayReferencia[padreSalida] = padreDestino;
				conexionesFinales.add(conexion);
				conexionesMax++;
				pesoConexiones += conexion.getPeso();
			}
			
		}
		
		System.out.println("Fin");
		return pesoConexiones;
		
	}
	
	private int buscarPadre(int nodo) {
		
		if(arrayReferencia[nodo] == nodo) {
			return nodo;
		}
		return buscarPadre(arrayReferencia[nodo]);
	}
	
	public int[][] getMatrizAdjacencia() {
		return matrizAdjacencia;
	}

	public void setMatrizAdjacencia(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = matrizAdjacencia;
	}
	
	public ArrayList<Conexion> getConexionesFinales() {
		return conexionesFinales;
	}
}


