package dfs.b2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,rain, safetyZone=0;
	static int[][] height;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		height = new int[N][N]; 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for (int i = 0;i<=100;i++) {
			rain = i; 
			int cnt = 0;
			visited = new boolean[N][N];

			
			for (int j = 0;j<N;j++) {
				for (int k=0;k<N;k++) {
					if (height[j][k]>rain && visited[j][k]==false) {
						dfs(j,k);
						cnt++;
					}
				}
			}
			
			safetyZone = Math.max(safetyZone, cnt);
			
		}
		System.out.println(safetyZone);
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		int nx, ny;
		
		for (int i =0;i<4;i++) {
			nx  = x + dx[i];
			ny = y + dy[i];
			if (nx>=0&&ny>=0&&nx<N&&ny<N) {
				if (visited[nx][ny] == false && height[nx][ny]>rain) {
					dfs(nx,ny);
				}
			}
			
		}
		
		
	}

}
