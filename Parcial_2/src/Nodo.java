
public class Nodo implements Comparable<Nodo> {

	private int id;
	private int distancia;


	public Nodo(int id) {
		this.id = id;
	}

	public Nodo(int id, int distancia) {
		this.id = id;
		this.distancia = distancia;
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


	@Override
	public int compareTo(Nodo o) {
		return this.distancia - o.distancia;
	}

}