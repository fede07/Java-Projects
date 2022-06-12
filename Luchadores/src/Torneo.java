
public class Torneo {
	private int[] dominados;
	private Luchador[] luchadores;
	
	public Torneo(int cantLuchadores) {
		luchadores = new Luchador[cantLuchadores];
	}
	
	public boolean agregarLuchador(Luchador luchador) {
		int i = 0;
		while(luchadores[i]!=null) {
			i++;
		}
		if(i>=luchadores.length) {
			return false;
		}
		luchadores[i]=luchador;
		return true;
	}
}
