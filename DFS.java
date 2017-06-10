import java.io.*;
import java.util.*;

public class DFS {
	public static void main(String args[])
	{
		Graph g = new Graph(8);

		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(4, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 7);
		g.addEdge(7, 6);
		
		

		System.out.println("Depth First Traversal "+ "(starting point : 0)");
		g.DFS(0);
		g.Time();

	}
}

class Graph {

	private int V;   // Number of vertices
	private int TimeArray [][] = new int [8][2];
	private int time=0;


	private LinkedList<Integer> adj[];

	Graph(int v){

		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	//Add edge methods in the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w);  
	}

	void DepthFirstSearch(int v, boolean visited[])
	{
		// Print all vertex
		visited[v] = true;
		System.out.print(v+" ");
		
		time++;
		TimeArray [v][0] = time;

		Iterator<Integer> i = adj[v].listIterator();   
		
		// Recursive method repeats itself until all vertex is visited
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n]){
				DepthFirstSearch(n, visited);
			}
		}
		time++;
		TimeArray [v][1] = time;
	}

	// The function to do DFS traversal. It uses recursive DepthFirstSearch()
	void DFS(int v)
	{
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DepthFirstSearch(v, visited);

		for (int a = 0; a < visited.length; a++) {
			if(!visited[a]){
				DepthFirstSearch(a,visited);
			}
		}
	}

	void Time(){
		System.out.println();
		for(int i=0;i<TimeArray.length;i++){
			for(int j = 0; j< 2 ; j++){
				if(j==0){
					System.out.print("Vertex : "+i+" --> Discovery Time : "+TimeArray[i][j]+"	");
				}
				else if(j==1){
					System.out.println("Finishing Time : "+TimeArray[i][j]);
				}
			}
		}

		String wellFormed="";

		for(int k=1;k<=time;k++){
			for(int i=0;i<TimeArray.length;i++){
				for(int j = 0; j< 2 ; j++){
					if(TimeArray[i][j]==k && j==0){
						wellFormed = wellFormed+"("+i;
					}
					else if(TimeArray[i][j]==k && j==1){
						wellFormed = wellFormed+""+i+")";
					}
				}
			}
		}

		System.out.println(wellFormed);

	}

}