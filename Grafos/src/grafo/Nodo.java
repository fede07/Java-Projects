package grafo;

public class Nodo implements Comparable<Nodo> {

	private int id;
	private int distancia;
	private int prioridad;
	private int[] arrayAdj;

	public Nodo(int id) {
		this.id = id;
	}

	public Nodo(int id, int distancia) {
		this.id = id;
		this.distancia = distancia;
	}

	public Nodo(int id, int[] arrayAdj) {
		this.id = id;
		this.setArrayAdj(arrayAdj);
	}

	public int getID() {
		return id;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int[] getArrayAdj() {
		return arrayAdj;
	}

	public void setArrayAdj(int[] arrayAdj) {
		this.arrayAdj = arrayAdj;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.distancia - o.distancia;
	}

	public boolean comparar(Nodo otro) {
		return this.id == otro.id;
	}

}