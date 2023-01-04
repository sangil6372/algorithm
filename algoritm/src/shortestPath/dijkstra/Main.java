package shortestPath.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static final int INF = 9999999;
	static int V;
	static int[] dist;
	static ArrayList<ArrayList<Node>> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수

		int K = Integer.parseInt(br.readLine()); // 시작 정점

		
		dist = new int[V + 1]; // K에서 부터 거리 갱신하며 저장
		Arrays.fill(dist, INF);

		arr = new ArrayList<>();
		
		for (int i = 0;i<V+1;i++) {
			arr.add(new ArrayList<>());
		}
		
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr.get(u).add(new Node(v, w));
		}

		dijstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
				continue;
			}
			sb.append(dist[i] + "\n");
		}

		System.out.println(sb);

	}

	public static class Node {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

	}

	public static void dijstra(int start) {

		PriorityQueue<Node> pQueue = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});

		pQueue.add(new Node(start, 0));
		dist[start] = 0;

		while (!pQueue.isEmpty()) {

			Node curNode = pQueue.poll();

			if (curNode.weight>dist[curNode.end]) continue;

			for (Node n : arr.get(curNode.end)){
				if (dist[n.end] > curNode.weight + n.weight) {
					dist[n.end] = curNode.weight +n.weight;
					pQueue.add(new Node(n.end, dist[n.end]));
				}
			}
			
		
		}

	}

}
