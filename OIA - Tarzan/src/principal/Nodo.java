package principal;

public class Nodo implements Comparable<Nodo>{

	private int id;
	private int x;
	private int y;
	private int prioridad = 0;
	
	public Nodo(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public double distanciaA(Nodo otro) {
		
		int distX = otro.x - this.x;  
		int distY = otro.y - this.y;
		
		return Math.hypot(distX, distY);
		
	}

	public int getId() {
		return id;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.prioridad - o.prioridad;
	}
	
	public boolean comparar(Nodo o) {
		return this.id == o.id;
	}
	
	
}
