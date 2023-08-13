import java.util.Scanner;

public class S1954 {
	public static void main(String[] args) {
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			int y = 0;
			int x = 0;
			int d = 0;
			
			for(int i=1; i<=N*N; i++) {
				map[y][x] = i;
				
				y += dy[d];
				x += dx[d];
				
				if(y < 0 || x < 0 || y >= N || x >= N || map[y][x] != 0) {
					y -= dy[d];
					x -= dx[d];
					d = (d+1) % 4;
					y += dy[d];
					x += dx[d];
				}
			}
			
			System.out.println("#" + t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
