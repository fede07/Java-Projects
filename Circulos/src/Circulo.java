
public class Circulo {
	private Punto centro;
	private double radio;
	
	public Circulo() {
		this.centro = new Punto();
		this.radio = 0;
	}
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public boolean intersectaCon(Circulo otro) {
		
		double distancia = this.centro.distancia(otro.centro);
		double radio = this.radio + otro.radio;
		
		return distancia<=radio;
		
	}

}
