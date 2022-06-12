package unlam.progava.oia;

import java.util.ArrayList;

public class Ronda {

	private ArrayList<Aventurero> aventureros;
	private ArrayList<Aventurero> eliminados;
	private int ganador;
	
	Ronda(int cantidadAventureros){
		aventureros = new ArrayList<Aventurero>();
		for(int i = 0; i<cantidadAventureros; i++) {
			aventureros.add(new Aventurero(i+1));
		}
	}
	
	public int cebar(ArrayList<Integer> movimientos) {
		
		eliminados = new ArrayList<Aventurero>();
		
		int adicional = 0;
		
		for(Integer movimiento : movimientos) {
			int movReal = movimiento % aventureros.size();
			movReal += adicional;
			movReal %= aventureros.size();
			eliminados.add(aventureros.remove(movReal));
			adicional = movReal;
		}
		
		ganador = aventureros.get(0).getNumero();
		return ganador;
		
	}

	public ArrayList<Aventurero> getAventureros() {
		return aventureros;
	}

	public void setAventureros(ArrayList<Aventurero> aventureros) {
		this.aventureros = aventureros;
	}

	public int getGanador() {
		return ganador;
	}

	public ArrayList<Aventurero> getEliminados() {
		return eliminados;
	}
	
}
