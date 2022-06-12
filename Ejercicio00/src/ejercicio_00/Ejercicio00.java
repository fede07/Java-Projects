package ejercicio_00;

public class Ejercicio00 {

	public static void main(String[] args) {
		int[][] matriz = {{1,2,3},
						  {4,2,6},
						  {7,8,2}};
		
		Ejercicio00 miEjercicio = new Ejercicio00();
		
		System.out.print(miEjercicio.diagonalSum(matriz));
		
	}
	
	public boolean diagonalSum (int [][] matriz) {
		
		int suma = 0;
		boolean esSum = true;
		int i = 0;
		
		
		do {
			suma += matriz[i][i];
			if(i<matriz.length-1 && suma != matriz[i+1][i+1])
			{
					esSum = false;
			}
	
			i++;
				
		}while(esSum && i< matriz.length);
		
		return esSum;
	}
}
