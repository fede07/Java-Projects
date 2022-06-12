package unlam.progava.oia;

public class Aventurero {
	private int numero;
	
	@Override
	public String toString() {
		return "Aventurero [numero=" + numero + "]";
	}

	Aventurero(int numero){
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	
}
