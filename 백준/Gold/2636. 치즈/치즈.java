import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int N, M;
	static int count = 0;
	static int[][] board;
	static boolean[][] visited;
	
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
		
		board = new int[N][M];
		
		int cheese = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				board[i][j] = temp;
				if(temp == 1) cheese++;
			}
		}
		
		int temp = 0;
		while(cheese != 0) {
			bfs(0, 0);
			temp = cheese;
			cheese -= remove();
		}
		
		sb.append(count).append("\n").append(temp);
		System.out.println(sb.toString());
	}

	private static int remove() {
		int remove = 0;
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(board[y][x] == 2) {
					remove++;
					board[y][x] = 0;
				}
			}
		}
		
		return remove;
	}

	private static void bfs(int y, int x) {
		visited = new boolean[N][M];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y,  x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx]) {
					if(board[ny][nx] == 1) {
						board[ny][nx] = 2;
						visited[ny][nx] = true;
					} else if(board[ny][nx] == 0) {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		count++;
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}
}
