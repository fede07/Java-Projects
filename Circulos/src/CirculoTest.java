import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CirculoTest {

	@Test
	void test1() {
		
		Circulo c1 = new Circulo(new Punto(0,0), 1);
		Circulo c2 = new Circulo(new Punto(1,1), 1.5);
		
		boolean resultado = c1.intersectaCon(c2);
		boolean esperado = true;
		
		assertEquals(esperado, resultado);
	}

	@Test
	void test2() {
		
		Circulo c1 = new Circulo(new Punto(0,0), 1);
		Circulo c2 = new Circulo(new Punto(10,10), 1.5);
		
		boolean resultado = c1.intersectaCon(c2);
		boolean esperado = false;
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	void test3() {
		
		Circulo c1 = new Circulo(new Punto(0,0), 1);
		Circulo c2 = new Circulo(new Punto(0,0), 1.5);
		
		boolean resultado = c1.intersectaCon(c2);
		boolean esperado = true;
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	void test4() {
		
		Circulo c1 = new Circulo(new Punto(0,0), 10);
		Circulo c2 = new Circulo(new Punto(10,10), 20);
		
		boolean resultado = c1.intersectaCon(c2);
		boolean esperado = true;
		
		assertEquals(esperado, resultado);
	}
	
}
