package codingNinjas26;

import java.util.Scanner;
import java.util.HashMap;
public class Graph {

	public static boolean[][] takeGraphInput() {
		int n, m;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		boolean edges[][] = new boolean[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			int first = s.nextInt();
			int second = s.nextInt();
			edges[first][second] = true;
			edges[second][first] = true;
		}
		return edges;
	}
	
	public static void main(String[] args) {
		boolean[][] edges = takeGraphInput();
		Scanner s = new Scanner(System.in);
		//int startVertex = s.nextInt();
		//int endVertex = s.nextInt();
		//int n = edges.length - 1;
		//boolean visited[] = new boolean[n + 1];
		//boolean ans = hasPath(edges, startVertex, endVertex, visited);
		//boolean ans = isConnected(edges, startVertex);
		//System.out.println(ans);
		int startVertex = 1;
        HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
        boolean answer = isColorPossible(edges,startVertex,visited,0);
        if(answer){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
	}

	private static boolean isConnected(boolean[][] edges, int startVertex, boolean visited[]) {
		if(visited[startVertex]){
			return true;
		}
		visited[startVertex] = true;
		int n = edges.length - 1;
		for(int i=1;i<=n;++i){
			if(edges[startVertex][i]){
				boolean answer = isConnected(edges, i, visited);
				if(!answer){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isConnected(boolean edges[][],int startVertex){
		boolean visited[] = new boolean[edges.length];
		isConnected(edges, startVertex,visited);
		for(int i=1;i<visited.length;++i){
			if(!visited[i])return false;
		}
		return true;
	}
	      
	    
	    public static boolean isColorPossible(boolean edges[][],int startVertex,
	    HashMap<Integer,Integer> visited,int currentColor){
	     if(visited.containsKey(startVertex)){
	         if(visited.get(startVertex) == currentColor){
	             return true;
	         } 
	         return false;
	      }
	      visited.put(startVertex,currentColor);
	      for(int i=1;i<edges.length;++i){
	          if(edges[startVertex][i]){
	             boolean answer = true;
	          if(currentColor==0)
	          answer = isColorPossible(edges,i,visited,1);
	          if(currentColor==1)
	          answer = isColorPossible(edges,i,visited,0);
	          if(!answer)return answer;
	          }
	      }
	        return true;
	    }
	

	
	private static boolean hasPath(boolean[][] edges, int startVertex,
			int endVertex, boolean visited[]) {
		if (startVertex == endVertex) {
			return true;
		}
		if (edges[startVertex][endVertex]) {
			return true;
		}
		
		visited[startVertex] = true;
		int n = edges.length - 1;
		for (int vertex = 1; vertex <= n; vertex++) {
			if (edges[startVertex][vertex]) {
				if (!visited[vertex]) {
					boolean path = hasPath(edges, vertex, endVertex, visited);
					if (path) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	

}

