package grafo;

public class Borde implements Comparable<Borde>{

	private int salida;
	private int destino;
	private int peso;
	
	public Borde(){
		this.peso = 0;
	}
	
	public Borde(int salida, int destino, int peso) {
		this.salida = salida;
		this.destino = destino;
		this.peso = peso;
	}

	@Override
	public int compareTo(Borde otro) {
		return this.peso - otro.getPeso();
	}

	public int getSalida() {
		return salida;
	}

	public void setSalida(int salida) {
		this.salida = salida;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
}
