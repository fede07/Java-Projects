
public class Luchador {

	private int altura;
	private int peso;
	
	Luchador(int peso, int altura){
		this.altura = altura;
		this.peso = peso;
	}
	
	public boolean dominar(Luchador otroLuchador) {
		if((this.altura >= otroLuchador.altura && this.peso > otroLuchador.peso) ||
			(this.peso > otroLuchador.peso && this.altura > otroLuchador.altura) ||
			(this.altura >= otroLuchador.altura && this.peso > otroLuchador.peso))
			return true;
		else
			return false;
	}
}
