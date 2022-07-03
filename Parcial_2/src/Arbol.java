import java.util.ArrayList;

public class Arbol {

	private Grafo grafo;
	private int[] apuntado;
	private ArrayList<Integer> raices;
	private ArrayList<Integer> nodosInvalidos;
	private boolean arbol;
	private boolean r1;
	private boolean r2;
	private boolean r3;
	private boolean[] visitados;
	//private int[] distancias;

	Arbol(Grafo grafo, int[] apuntado) {
		this.grafo = grafo;
		this.apuntado = apuntado;
	}

	public void analizarArbol() {
		raices = new ArrayList<Integer>();
		nodosInvalidos = new ArrayList<Integer>();

		for (int i = 1; i < apuntado.length; i++) {
			if (apuntado[i] == 0) {
				raices.add(i);
			}
			if (apuntado[i] > 1) {
				nodosInvalidos.add(i);
			}
		}
		if (raices.size() == 1) {
			//distancias = grafo.dijkstra(raices.get(0));
			visitados = grafo.bfsInterno(raices.get(0));
			r1 = true;
			r3 = true;
		}
		if (nodosInvalidos.size() == 0) {
			r2 = true;
		}
		int i=0;
		if(visitados != null) {
			while(r3 && i<visitados.length) {
				if (visitados[i] == false) {
					r3 = false;
				}
				i++;
			}			
		}
		if (r1 && r2 && r3) {
			arbol = true;
		}else {
			arbol = false;
		}
	}

	public boolean isArbol() {
		return arbol;
	}

	public boolean isR1() {
		return r1;
	}

	public boolean isR2() {
		return r2;
	}

	public boolean isR3() {
		return r3;
	}


	public ArrayList<Integer> getNodosInvalidos() {
		return nodosInvalidos;
	}

//	public int[] getDistancias() {
//		return distancias;
//	}

	public ArrayList<Integer> getRaices() {
		return raices;
	}

	public boolean[] getVisitados() {
		return visitados;
	}
	

}
