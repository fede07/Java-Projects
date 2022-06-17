package grafo;
import java.util.ArrayList;

public class Grafo {
	
	private int vertices;
	private int bordes;
	private ArrayList<Borde> listaBordes;
	
	public Grafo(int vertices, int bordes){
		this.vertices = vertices;
		this.bordes = bordes;
		
		listaBordes = new ArrayList<Borde>();
		
		for(int i = 0; i<bordes; i++) {
			Borde borde = new Borde();
			listaBordes.add(borde);
		}
	}
	
	public void agregarBorde(int i, int salida, int destino, int peso) {
		listaBordes.get(i).setSalida(salida);
		listaBordes.get(i).setDestino(destino);
		listaBordes.get(i).setPeso(peso);
	}
	
	public int buscar(ArrayList<SubGrafo> subsets, int i) {
		
		if(subsets.get(i).getPadre() != i) {
			int padre = buscar(subsets, subsets.get(i).getPadre());
			subsets.get(i).setPadre(padre);
		}

		return subsets.get(i).getPadre();
	}
	
	private void union(ArrayList<SubGrafo> subsets, int rangoX, int rangoY) {
		
		int raizX = buscar(subsets, rangoX);
		int raizY = buscar(subsets, rangoY);
		
		if(subsets.get(raizX).getRango() < subsets.get(raizY).getRango()) {
			subsets.get(raizX).setPadre(raizY);
		}else if(subsets.get(raizX).getRango() > subsets.get(raizY).getRango()) {
			subsets.get(raizY).setPadre(raizX);
		}
		else {
			subsets.get(raizY).setPadre(raizX);
			subsets.get(raizX).aumentarRango();
		}
	}
	
	public int pesoMinimoKruskal() {
		Borde resultado[] = new Borde[vertices];
		int e = 0;
		int i = 0;
		
		for(i = 0; i<vertices; i++) {
			resultado[i] = new Borde();
		}
		
		listaBordes.sort(null);
		
		ArrayList<SubGrafo> subsets = new ArrayList<SubGrafo>();
		for(i = 0; i < vertices; i++) {
			subsets.add(new SubGrafo(i, 0));
		}
		
		i = 0;
		
		while(e < vertices-1) {
			Borde siguiente = listaBordes.get(i++);
			
			int salida = siguiente.getSalida()-1;
			int destino = siguiente.getDestino()-1;
			
			int x = buscar(subsets, salida);
			int y = buscar(subsets, destino);
			
			if(x != y) {
				resultado[e++] = siguiente;
				union(subsets, x, y);
			}
			
		}
		
		int pesoMinimo = 0;
		
		for (Borde borde : resultado) {
			pesoMinimo += borde.getPeso();
		}
		
		return pesoMinimo;
	}

	public int getBordes() {
		return bordes;
	}

	public void setBordes(int bordes) {
		this.bordes = bordes;
	}
	
	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}
}
