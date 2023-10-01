import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int result = 0;
	static int[][] board;
	static boolean[] used;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		int count;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		used = new boolean[26];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = line.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(result);
	}

	private static void dfs(int y, int x, int count) {
		if(used[board[y][x]]) {
			result = Math.max(result, count);
			return;
		} else {
			used[board[y][x]] = true;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(isRange(ny, nx)) {
					dfs(ny, nx, count + 1);
				}
			}
			
			used[board[y][x]] = false;
		}
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < R && nx < C) return true;
		return false;
	}
}