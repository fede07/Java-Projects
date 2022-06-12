
public class Punto {
	
	private double x;
	private double y;
	
	public Punto() {
		this.x = 0;
		this.y = 0;
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Punto otro) {
		
		double termA = otro.x - this.x;
		double termB = otro.y - this.y;
			
		return Math.hypot(termA, termB);
		
	}
}
