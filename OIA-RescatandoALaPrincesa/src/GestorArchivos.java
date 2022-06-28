import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestorArchivos {

	private String path;

	public GestorArchivos(String path) {
		this.path = path;

	}
	
	public Grafo leerArchivo() {
		
		try {
			Scanner scanner = new Scanner(new File(path+ ".in"));
			int cantNodos = scanner.nextInt();
			int cantConexiones = scanner.nextInt();
			int cantDragones = scanner.nextInt();
			int posPrincesa = scanner.nextInt();
			int posPrincipe = scanner.nextInt();
			
			Map<Integer, Boolean> mapaDragones = new HashMap<Integer, Boolean>();
			
			for(int i = 0; i<cantDragones;i++) {
				int posDragon = scanner.nextInt();
				mapaDragones.put(posDragon, true);
			}
			
			Map<Integer, ArrayList<Nodo> > listaAdj = new HashMap<Integer, ArrayList<Nodo>>(); 
			
			for(int i = 0; i< cantConexiones; i++) {
				int salida = scanner.nextInt();
				int destino = scanner.nextInt();
				int peso = scanner.nextInt();
				
				if(listaAdj.containsKey(salida)) {
					listaAdj.get(salida).add(new Nodo(destino, peso));
				}else {
					listaAdj.put(salida, new ArrayList<Nodo>());
					listaAdj.get(salida).add(new Nodo(destino, peso));
				}
				
				if(listaAdj.containsKey(destino)) {
					listaAdj.get(destino).add(new Nodo(salida, peso));
				}else {
					listaAdj.put(destino, new ArrayList<Nodo>());
					listaAdj.get(destino).add(new Nodo(salida, peso));
				}
				

			}
			
			Grafo grafo = new Grafo(cantNodos, cantConexiones, listaAdj, posPrincipe, posPrincesa);
			grafo.setMapaDragones(mapaDragones);
			
			scanner.close();
			
			return grafo;
			
			
		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo");
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
