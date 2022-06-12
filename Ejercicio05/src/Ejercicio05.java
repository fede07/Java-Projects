import java.io.*;
import java.util.Scanner;
//import java.lang.Object;

public class Ejercicio05 {
	
	public static int[] vendedorasEliminadas = new int[100];
	/*
	 * 0 = no existe la vendedora
	 * -1 = no alcanza las ventas minimas
	 * X = fue la mejor o es la mejor
	 */
	
	public static void main(String[] args) {
		int ventasMinimas = definirVentasMinimas();
		int[] mejorVendedora = new int[5];
		do {
			mejorVendedora = procesarArchivo( ventasMinimas );
			ventasMinimas++;	
//			System.out.println("---------------------------------");
//			System.out.println("cantidad de ventas: " + mejorVendedora[0]);
//			System.out.println("total acumulado " + mejorVendedora[1]);
//			System.out.println("numero vendedora " +mejorVendedora[2]);
//			System.out.println("hubo empate " +mejorVendedora[3]);
//			System.out.println("cantidad de ventas que hizo  " +mejorVendedora[4]);
//			System.out.println("cantidad de ventas minimas requeridas "+ventasMinimas);

			//System.out.println(mejorVendedora[1]);
			//i++;
			//System.out.println(i);
			
			/*vendedorasEliminadas
			 * 0 = no existe la vendedora
			 * 1 = no alcanza las ventas minimas
			 * X = fue la mejor o es la mejor
			 */
			int i = 0;
			System.out.println("---------------");
			while(vendedorasEliminadas[i] != 0 && i<100) {
				System.out.println(vendedorasEliminadas[i] + " " + mejorVendedora[1]);
				if(vendedorasEliminadas[i] != mejorVendedora[1])
					vendedorasEliminadas[i] = -1;
				i++;				
			}
		}while( mejorVendedora[3] == 1 && mejorVendedora[4] >= ventasMinimas);
		
		escribirArchResultado(mejorVendedora);
		
	}


	public static int definirVentasMinimas() {
		/*ReversedLinesFileReader object = null;
		 try {
		  object = new ReversedLinesFileReader(file);
		  object.readLine()
		 } catch (IOException e) {
		  e.printStackTrace();
		 }finally{
		  try {
		   object.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }*/
		int ventasMinimas=0;
		try {
			Scanner refarch = new Scanner(new File("premio.in"));
			while (refarch.hasNextInt()) {//busco el final del archivo
				ventasMinimas = refarch.nextInt();
			}
			refarch.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ventasMinimas;//devuelvo el ultimo numero, la cantidad de ventas requeridas
	}
	
	public static int[] procesarArchivo(int ventasMinimas) {
		int[] mejorVendedora = new int[5];//cantVentas | acumulado | numeroVendedora | huboEmpate
			try {
				Scanner refarch = new Scanner(new File("premio.in"));
				
				int numeroVendedora = 1;
				refarch.nextInt();
				while (refarch.hasNextInt()) {
					int ventasVendActual = refarch.nextInt();			
					if(refarch.hasNextInt()) {
						int[] ventasRealizadas = new int[ventasVendActual];
						for(int i = 0; i<ventasVendActual; i++) {
							ventasRealizadas[i] = refarch.nextInt();
						}
						if(ventasRealizadas.length >= ventasMinimas && vendedorasEliminadas[numeroVendedora-1]!=-1) {
System.out.println(">> "+vendedorasEliminadas[numeroVendedora-1]);
			//tiene mas ventas de las necesarias, se puede acumular
							int[] totalVendActual = calcularVentas(ventasRealizadas, ventasMinimas);
									//totalVentas | ventasContadas
							if(totalVendActual[0] > mejorVendedora[1]) {
								mejorVendedora[0] = ventasMinimas;
								mejorVendedora[1] = totalVendActual[0];
								mejorVendedora[2] = numeroVendedora;
								mejorVendedora[3] = 0;//empate
								mejorVendedora[4] = ventasRealizadas.length;//total de ventas posibles
								vendedorasEliminadas[numeroVendedora-1] = totalVendActual[0];
							}
							else if(totalVendActual[0] == mejorVendedora[1] && totalVendActual[1] == ventasMinimas) {
								mejorVendedora[3] = 1;
								vendedorasEliminadas[numeroVendedora-1] = totalVendActual[0];
								if(mejorVendedora[4] < ventasRealizadas.length)
									mejorVendedora[4] = ventasRealizadas.length;
							}
						}
						else {
							vendedorasEliminadas[numeroVendedora-1] = -1;
						}
						numeroVendedora++;
					}
				}
				refarch.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return mejorVendedora;
	}
	
	
	public static int[] calcularVentas (int[] ventasRealizadas, int ventasMinimas) {
		int[] totalAcumulado = new int[2];//totalVendido | cantidadVentas
		int totalTemporal;
		for(int i = 0; ventasRealizadas.length - i > ventasMinimas-1; i++) {
			totalTemporal = 0;
			int j;
			for(j = 0; j<ventasMinimas; j++) {
				totalTemporal += ventasRealizadas[i+j];
			}
			if (totalTemporal > totalAcumulado[0]) {
				totalAcumulado[0] = totalTemporal;
				totalAcumulado[1] = j;
			}
		}
		return totalAcumulado;
	}
	
	/*
	 
	 */
		
	public static void escribirArchResultado (int[] mejorVendedora) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("premio.out");
			pw = new PrintWriter(fichero);
			if(mejorVendedora[3] == 1) {
				pw.println("No se pudo desempatar");
			}
			else if(mejorVendedora[0] == 0) {
				pw.println("No hubo ganadora");
			}
			else {
				pw.println(mejorVendedora[2]);
				pw.println(mejorVendedora[0] + " " + mejorVendedora[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
	
	
}
