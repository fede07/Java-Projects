import static org.junit.Assert.*;

import org.junit.Test;

public class TEST_DETONADORA {

	@Test
	public void testAtaque() {
		Dummy dummy = new Dummy();
		Detonadora detonadora = new Detonadora();
		
		detonadora.atacar(dummy);
		assertEquals(dummy.getVida(),928);
	}
	
	@Test
	public void testDescanso() {
		Dummy dummy = new Dummy();
		Detonadora detonadora = new Detonadora();
		
		detonadora.descansar();
		detonadora.atacar(dummy);
		
		assertEquals(dummy.getVida(),784);
		
		
	}
	
	@Test
	public void testRecibirAtaque() {
		Dummy dummy = new Dummy();
		Detonadora detonadora = new Detonadora();
		
		dummy.atacar(detonadora);
		assertEquals(detonadora.getVida(), 73);
	}
	
		
	@Test
	public void testMuerte() {
		Dummy dummy = new Dummy();
		Detonadora detonadora = new Detonadora();
		
		dummy.atacar(detonadora);
		dummy.atacar(detonadora);
		dummy.atacar(detonadora);
		dummy.atacar(detonadora);
		dummy.atacar(detonadora);
		dummy.atacar(detonadora);

		
		assertEquals(detonadora.getVida(), 0);
	}
}
