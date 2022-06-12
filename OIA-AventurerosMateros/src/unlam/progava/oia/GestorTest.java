package unlam.progava.oia;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorTest {

	@Test
	public void test() {
		GestorDeArchivos gestor = new GestorDeArchivos("src/unlam/progava/oia/in/aventureros.in");
		
		gestor.leerArchivo();
		
		int cantAv = gestor.getCantAventureros();
		int cantMov = gestor.getMovimientos().size();
		
		assertEquals(4, cantAv);
		assertEquals(3, cantMov);
		
	}

}
