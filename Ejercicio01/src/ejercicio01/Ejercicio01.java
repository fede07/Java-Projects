package ejercicio01;

public class Ejercicio01 {
	
	public static void main(String[] args) {
		int[][] matriz =   {{0,2,3,3},
							{4,1,8,1},
							{7,8,2,4}};
		
		Ejercicio01 miEjercicio = new Ejercicio01();
		
		if(miEjercicio.multEsCero(matriz))
		{
			System.out.println("La multiplicacion de todos los elementos de la matriz es 0");
		}else {
			System.out.println("La multiplicacion de todos los elementos de la matriz no es 0");
		}
		
	}	
	
	public boolean multEsCero(int[][] matriz) {
		int i=0;
		int j=0;
		boolean result = false;
		
		while(!result && i<matriz.length){
			while(!result && j<matriz[0].length) {
				if(matriz[i][j] == 0)
				{
					result = true;
				}
				j++;
			}
			i++;
			j=0;
		}
		
		return result;
		
	}
	
}
