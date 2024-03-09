import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] board;
	static int[][] check;
	static int cycle = 1;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		check = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(check[y][x] == 0) {
					checkCycle(y, x);
				}
			}
		}
		
		System.out.println(result);
	}

	private static void checkCycle(int y, int x) {
		check[y][x] = cycle;
		
		int[] dir = checkDir(board[y][x]);
		int ny = y + dir[0];
		int nx = x + dir[1];
		
		if(check[ny][nx] == 0) {
			checkCycle(ny, nx);
		} else {
			if(check[ny][nx] == cycle) result++;
			cycle++;
		}
	}
	
	private static int[] checkDir(char temp) {
		if(temp == 'U') return new int[] {-1, 0};
		else if(temp == 'D') return new int[] {1, 0};
		else if(temp == 'L') return new int[] {0, -1};
		else return new int[] {0, 1};
	}
}
