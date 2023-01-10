package ploydWarwhall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// b11404
public class Main {

	static long[][] dist;
	final static long INF = 9900001;
	static int V;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(br.readLine());

		dist = new long[V + 1][V + 1];

		for (int i = 0; i < V + 1; i++) {
			Arrays.fill(dist[i], INF);
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b],c); // 노선은 하나가 아닐 수 있다는거 (함정)
		}
		// 노드 정보 노드->b : c 입력 완료

		for (int i = 1; i <= V; i++) {
			ployd(i);
		}
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (dist[i][j]==INF) {
					System.out.print("0 ");
					continue;
				}
				System.out.print(dist[i][j] + " ");;
			}
			System.out.println();
		}

	}


	public static void ployd(int s) {

		for (int i = 1; i <= V; i++) {
			if (s==i||dist[i][s]==INF) continue;
			for (int j = 1; j <= V; j++) {
				if (s==j||i==j) continue;
				if (dist[i][j]>dist[i][s] + dist[s][j]) {
					dist[i][j] = dist[i][s] + dist[s][j];
				}
			}
		}

	}

}
