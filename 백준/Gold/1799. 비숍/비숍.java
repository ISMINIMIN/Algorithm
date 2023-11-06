import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int black = 0;
	static int white = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		black(0, 0, 0);
		white(0, 1, 0);
		System.out.println(black + white);
	}

	private static void black(int ny, int nx, int count) {
		black = Math.max(black, count);
		
		for(int i=ny; i<N; i++) {
			for(int j=nx; j<N; j+=2) {
				if(board[i][j] == 0) continue;
				if(!check(i, j)) continue;
				if(visited[i][j]) continue;
				
				visited[i][j] = true;
				black(i, j+2, count+1);
				visited[i][j] = false;
			}
			
			nx = (i+1) % 2;
		}
	}
	
	private static void white(int ny, int nx, int count) {
		white = Math.max(white, count);
		
		for(int i=ny; i<N; i++) {
			for(int j=nx; j<N; j+=2) {
				if(board[i][j] == 0) continue;
				if(!check(i, j)) continue;
				if(visited[i][j]) continue;
				
				visited[i][j] = true;
				white(i, j+2, count+1);
				visited[i][j] = false;
			}
			
			nx = (i+2) % 2;
		}
	}

	private static boolean check(int y, int x) {
		for(int i=0; i<y; i++) {
			int x1 = x - (y - i);
			int x2 = x + (y - i);
			if(x1 >= 0 && visited[i][x1]) return false;
			if(x2 < N && visited[i][x2]) return false;
		}
		
		return true;
	}
}