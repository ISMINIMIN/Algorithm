import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result = Integer.MAX_VALUE;
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				if(line.charAt(j) == 'B') board[i][j] = true;
				else board[i][j] = false;
			}
		}
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				checkBoard(i, j, board[i][j]);
			}
		}
		
		System.out.println(result);
	}

	private static void checkBoard(int startI, int startJ, boolean check) {
		int count = 0;
		
		for(int i=startI; i<startI+8; i++) {
			for(int j=startJ; j<startJ+8; j++) {
				if(board[i][j] != check) count++;
				check = !check;
			}
			check = !check;
		}
		
		count = Math.min(count, 64-count);
		result = Math.min(result, count);
	}
}
