package dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		dp[0] = 0;
		dp[1] = 1;

		System.out.println(fibonacciTD(n));
		System.out.println(fibonacciBU(n));
		sc.close();
	}
	
	static int dp[] = new int[100];
	
	//일반적인 재귀함수
	public static int fiboonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		 return fibonacciTD(n - 1) + fibonacciTD(n - 2);
	}
	
	// top-down 방식 재귀합수를 이용 (메모이제이션이 사용됨 = 값을 기억함)
	public static int fibonacciTD(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		
		// 메모이제이션 DP의 핵심
		if (dp[n] != 0)
			return dp[n];

		dp[n] = fibonacciTD(n - 1) + fibonacciTD(n - 2);
		return dp[n];
	}

	// bottom-up 방식 반복문을 이용
	public static int fibonacciBU(int n) {
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	
}
