package dfs.b2644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int V, endV;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int dist;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		V = sc.nextInt();
		
		graph = new ArrayList<>();
		
		for (int i =0;i<=V;i++) {
			graph.add(new ArrayList<>());
		}
		
		int startV = sc.nextInt();
		endV = sc.nextInt();
		
		int m = sc.nextInt();
		
		while(m-->0) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		// graph 채워 넣기 
		
		visited = new boolean[V+1];

		dist = -1;
		dfs(startV, 0);
		System.out.println(dist);
		
		sc.close();
	}

	static boolean flag;
	public static void dfs(int start, int depth) {
		visited[start] = true;

		if(start == endV) {
			dist = depth;
			return;
			
		}
		
		
		for (int n : graph.get(start)) {
			if (visited[n]==false) {
				dfs(n, depth + 1);
			}
		}	
	}
	
	
}
