package Punto;

import java.util.Objects;

public class Punto {
	
	private double x;
	private double y;
	
	
	public Punto() {
//		this.x = 0;
//		this.y = 0;
		this(0,0);
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
	
	public void desplazar(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	public Punto suma(Punto p) {
		Punto ps = new Punto(this.x +p.x, this.y +p.y);
		
		return ps;
	}
	
}
