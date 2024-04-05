import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] result;
	static char[][] board;
	static boolean[][] visited;
	
	static final char OUR = 'W';
	static final char ENEMY = 'B';
	static final int[] DY = {-1, 1, 0, 0};
	static final int[] DX = {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[M][N];
		visited = new boolean[M][N];
		result = new int[2];
		
		for(int y=0; y<M; y++) {
			String line = br.readLine();
			for(int x=0; x<N; x++) {
				board[y][x] = line.charAt(x);
			}
		}
		
		for(int y=0; y<M; y++) {
			for(int x=0; x<N; x++) {
				if(!visited[y][x]) {
					bfs(y, x);
				}
			}
		}
		
		sb.append(result[0]).append(" ").append(result[1]);
		System.out.println(sb.toString());
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		int count = 0;
		char team = board[y][x];
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			count++;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + DY[i];
				int nx = node.x + DX[i];
				
				if(isRange(ny, nx) && !visited[ny][nx]) {
					if(board[ny][nx] == team) {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		if(team == OUR) result[0] += count * count;
		if(team == ENEMY) result[1] += count * count;
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < M && x < N;
	}
}
