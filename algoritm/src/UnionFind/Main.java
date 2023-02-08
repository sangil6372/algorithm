package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] numSet;

	// b1717
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		numSet = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			numSet[i] = i;
		}

		// m = 연산 개수
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			a = findRoot(a);
			b = findRoot(b);
			
			if (oper == 1) {
				if (a == b)
					System.out.println("YES");
				else
					System.out.println("NO");
			} else
				unionSet(a, b);

		}
		br.close();
	}

	static int findRoot(int n) {

		if (n != numSet[n]) {
			n = findRoot(numSet[n]);
		}

		return numSet[n];
	}

	static void unionSet(int a, int b) {
		if (a < b)
			numSet[a] = b;
		else
			numSet[b] = a;

	}

}
