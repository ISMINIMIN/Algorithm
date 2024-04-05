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
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
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
		
		final char OUR = 'W';
		final char ENEMY = 'B';
		
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
					if(board[y][x] == OUR) result[0] += bfs(y, x, OUR);
					else result[1] += bfs(y, x, ENEMY);
				}
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
	}

	private static int bfs(int y, int x, char team) {
		int count = 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			count++;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx]) {
					if(board[ny][nx] == team) {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		return (int)Math.pow(count, 2);
	}

	private static boolean isRange(int y, int x) {
		if(y >= 0 && x >= 0 && y < M && x < N) return true;
		return false;
	}
}
