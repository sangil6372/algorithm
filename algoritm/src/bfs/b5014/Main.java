package bfs.b5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int F, U, D, G;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		F = sc.nextInt(); // 총 1 ~ F 층
		int S = sc.nextInt(); // Start 층
		G = sc.nextInt(); // 도착 층
		U = sc.nextInt(); // up
		D = sc.nextInt(); // down

		dist = new int[F + 1];

		bfs(S);

		if (dist[G] == 0 && S != G) {
			System.out.println("use the stairs");
		} else {
			System.out.println(dist[G]);
		}
		sc.close();
	}

	public static void bfs(int startV) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(startV);
		dist[startV] = 0;

		while (!queue.isEmpty()) {
			int next = queue.poll();

			if (next == G)
				return;

			if (next + U >= 1 && next + U <= F) {
				if (dist[next + U] == 0) {
					queue.add(next + U);
					dist[next + U] = dist[next] + 1;
				}
			}
			if (next - D >= 1 && next - D <= F) {
				if (dist[next - D] == 0) {
					queue.add(next - D);
					dist[next - D] = dist[next] + 1;
				}
			}

		}

	}

}
