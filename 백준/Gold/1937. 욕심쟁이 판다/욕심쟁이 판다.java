import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max = 0;
	static int[][] board;
	static int[][] dp;
	static boolean[][] visited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				max = Math.max(max, dfs(y, x));
			}
		}
		
		System.out.println(max);
	}

	private static int dfs(int y, int x) {
		if(dp[y][x] != 0) return dp[y][x];
		
		dp[y][x] = 1;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(isRange(ny, nx)) {
				if(board[ny][nx] > board[y][x]) {
					dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
				}
			}
		}
		
		return dp[y][x];
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x <N;
	}
}
