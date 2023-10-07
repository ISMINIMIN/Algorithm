import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int endY, endX;
	static int[][] map, result;
	static boolean[][] visited;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		int count;
		
		public Node(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		result = new int[N][M];
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == 2) {
					endY = y;
					endX = x;
				}
			}
		}
		
		bfs();
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(visited[y][x] || map[y][x] == 0) System.out.print(result[y][x] + " ");
				else System.out.print(-1 + " ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		visited = new boolean[N][M];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(endY, endX, 0));
		visited[endY][endX] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			result[node.y][node.x] = node.count;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx] && map[ny][nx] != 0) {
					queue.add(new Node(ny, nx, node.count+1));
					visited[ny][nx] = true;
				}
			}
		}
		
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		return false;
	}
}