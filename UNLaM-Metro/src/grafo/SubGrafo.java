package grafo;

public class SubGrafo {
	
	private int padre;
	private int rango;
	
	public SubGrafo(int padre, int rango) {
		this.padre = padre;
		this.rango = rango;
	}
	
	public int getRango() {
		return rango;
	}
	
	public int getPadre() {
		return padre;
	}
	
	public void setPadre(int padre) {
		this.padre = padre;
	}
	
	public void aumentarRango() {
		this.rango++;
	}
}