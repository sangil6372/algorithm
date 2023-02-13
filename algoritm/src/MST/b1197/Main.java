package MST.b1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static int[][] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다.
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		edges = new int[E][3]; //
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i][0] = A;
			edges[i][1] = B;
			edges[i][2] = C;

			
		}

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] < o2[2])
					return -1;
				else if (o1[2] == o2[2])
					return 0;
				else
					return 1;
			}
		});
		// 오름차순 완료 
		
		
		int MST = 0;
				
		for (int i = 0; i < E; i++) {
			// 연결 되어있으면 PASS
			if (find(edges[i][0])==find(edges[i][1])) continue;
			MST += edges[i][2];
			union(edges[i][0], edges[i][1]);
			
			
		}
		
		System.out.println(MST);
	}

	// 루트 찾는 find
	static int find(int n) {
		if (n != parents[n]) {
			n = find(parents[n]);
		}
		return n;
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA < rootB) {
			parents[rootB] = rootA;
		} else {
			parents[rootA] = rootB;

		}

	}

}
