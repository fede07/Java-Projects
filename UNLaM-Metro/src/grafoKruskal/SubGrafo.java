package grafoKruskal;

public class SubGrafo {
	
	private int padre;
	private int rango;
	
	public SubGrafo(int padre, int rango) {
		this.padre = padre;
		this.rango = rango;
	}
	
	public SubGrafo() {
	}

	public int getPadre() {
		return padre;
	}
	
	public int getRango() {
		return rango;
	}
	
	public void setPadre(int padre) {
		this.padre = padre;
	}
	
	public void aumentarRango() {
		this.rango++;
	}
}