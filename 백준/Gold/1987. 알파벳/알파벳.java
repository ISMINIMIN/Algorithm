import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int max = 1;
	static int R, C;
	static char[][] board;
	static boolean[] alphabet;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new boolean[26];
		board = new char[R][C];
		
		for(int y=0; y<R; y++) {
			String line = br.readLine();
			for(int x=0; x<C; x++) {
				board[y][x] = line.charAt(x);
			}
		}
		
		dfs(0, 0, 0);
		
		System.out.println(max);
	}

	private static void dfs(int y, int x, int count) {
		if(alphabet[board[y][x] - 'A']) {
			max = Math.max(max, count);
			return;
		} else {
			alphabet[board[y][x] - 'A'] = true;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(isRange(ny, nx)) {
					dfs(ny, nx, count + 1);
				}
			}
			
			alphabet[board[y][x] - 'A'] = false;
		}
	}

	private static boolean isRange(int y, int x) {
		if(y >= 0 && x >= 0 && y < R && x < C) return true;
		return false;
	}
}
