package divideAndConquer;

import java.util.Scanner;

//b2630
public class Main {
	
	static int count0 = 0;
	static int count1 = 0;
	static int[][] arr;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		countFold(0, 0, N);
		
		System.out.println(count0 +"\n" + count1);
		
		sc.close();
	}
	public static boolean checkColor(int row, int col, int length) {
		int color = arr[row][col];
		
		for (int i=row;i<length+row;i++) {
			for (int j=col;j<length+col;j++) {
				if (arr[i][j]!=color) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void countFold(int row, int col, int length) {
		
		
		if (checkColor(row,col,length)) {
			if(arr[row][col]==0) count0++;
			else count1++;
			return;
		}
		else {
			countFold(row,col,length/2);
			countFold(row, col+ length/2,length/2);
			countFold(row+length/2,col,length/2);
			countFold(row + length/2,col+ length/2,length/2);

		}
		
		
	}
	
}
