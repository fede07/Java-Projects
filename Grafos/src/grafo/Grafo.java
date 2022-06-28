package grafo;

import java.util.ArrayList;

public abstract class Grafo {
	
	abstract public ArrayList<Integer> bfs(int start, int end);
	
	abstract public void dfs(int inicio);
	
	abstract public int[] dijkstra(int inicio);
	
}
