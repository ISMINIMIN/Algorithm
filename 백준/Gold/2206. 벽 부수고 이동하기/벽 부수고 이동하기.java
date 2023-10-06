import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int max = 0;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		int count;
		boolean flag;
		
		public Node(int y, int x, int count, boolean flag) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.flag = flag;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int y=0; y<N; y++) {
			String line = br.readLine();
			for(int x=0; x<M; x++) {
				map[y][x] = line.charAt(x) - '0';
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, false));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.y == N-1 && node.x == M-1) return node.count;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx)) {
					if(map[ny][nx] == 0) {
						if(!node.flag && !visited[ny][nx][0]) {
							queue.add(new Node(ny, nx, node.count+1, false));
							visited[ny][nx][0] = true;
						} else if(node.flag && !visited[ny][nx][1]) {
							queue.add(new Node(ny, nx, node.count+1, true));
							visited[ny][nx][1] = true;
						}
					} else {
						if(!node.flag) {
							queue.add(new Node(ny, nx, node.count+1, true));
							visited[ny][nx][1] = true;
						}
					}
				}
			}
		}
		
		return -1;
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		return false;
	}
}