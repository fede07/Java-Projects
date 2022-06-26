
public class Conexion implements Comparable<Conexion> {
	
	private int salida;
	private int destino;
	private int peso;
	
	public Conexion(int salida, int destino, int peso) {
		this.salida = salida;
		this.destino = destino;
		this.peso = peso;
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

	@Override
	public int compareTo(Conexion o) {
		return  this.peso - o.peso;
	}
	
}
