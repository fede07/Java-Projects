package unlam.progava.oia;

import static org.junit.Assert.*;

import org.junit.Test;

public class RondaTest {

	@Test
	public void ganador() {
		GestorDeArchivos gestor = new GestorDeArchivos("src/unlam/progava/oia/in/aventureros.in");
		gestor.leerArchivo();
		
		Ronda ronda = new Ronda(gestor.getCantAventureros());
		
		int ganador = ronda.cebar(gestor.getMovimientos());
		
		assertEquals(3, ganador);
		
	}
	
	@Test
	public void testEliminados() {
		GestorDeArchivos gestor = new GestorDeArchivos("src/unlam/progava/oia/in/aventureros.in");
		gestor.leerArchivo();
		
		Ronda ronda = new Ronda(gestor.getCantAventureros());
		
		int ganador = ronda.cebar(gestor.getMovimientos());
		
		int tamaño = ronda.getEliminados().size();
		
		System.out.println(ronda.getEliminados());
		
		assertEquals(3, tamaño);
				
	}

}
