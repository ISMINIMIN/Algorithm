import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1249 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int N;
	static int[][] map;
	static int[][] check;
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			check = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					check[i][j] = Integer.MAX_VALUE; 
				}
			}
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			bfs(0, 0);
			
			System.out.println("#" + t + " " + check[N-1][N-1]);
		}
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		check[y][x] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(inRange(ny, nx) && check[ny][nx] > check[node.y][node.x] + map[ny][nx]) {
					queue.add(new Node(ny, nx));
					check[ny][nx] = check[node.y][node.x] + map[ny][nx];
				}
			}
		}
	}

	private static boolean inRange(int ny, int nx) {
		if(ny >=0 && nx >= 0 && ny < N && nx < N) return true;
		else return false;
	}
}