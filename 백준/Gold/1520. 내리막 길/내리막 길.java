import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map, dp;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	final static int INIT = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int y=0; y<M; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				dp[y][x] = INIT;
			}
		}
		
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int y, int x) {
		if(y == M-1 && x == N-1) return 1;
		
		if(dp[y][x] == INIT) {
			dp[y][x] = 0;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(isRange(ny, nx)) {
					if(map[ny][nx] < map[y][x]) {
						dp[y][x] += dfs(ny, nx);
					}
				}
			}
		}
		
		return dp[y][x];
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < M && x < N;
	}
}
