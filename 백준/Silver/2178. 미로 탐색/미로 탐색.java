import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 1, 0, 0}; // (상)(하)좌우
	static int[] dx = {0, 0, -1, 1}; // 상하(좌)(우)
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	static class Node {
		int y;
		int x;
		int count;
		
		public Node(int y, int x, int count) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x, 1));
		visited[y][x] = true;
		
		while(true) {
			Node node = queue.poll();
			
			if(node.y == N-1 && node.x == M-1) {
				System.out.println(node.count);
				break;
			}
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(ny >= 0 && nx >=0 && ny < N && nx < M) {
					if(!visited[ny][nx] && map[ny][nx] == 1) {
						queue.add(new Node(ny, nx, node.count+1));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
}