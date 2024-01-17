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
	static int[][] sea;
	static boolean[][] visited;
	
	static class Node {
		int y;
		int x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sea = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		
		while(true) {
			int check = 0;
			visited = new boolean[N][M];
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(sea[y][x] != 0 && !visited[y][x]) {
						bfs(y, x);
						check++;
					}
				}
			}
			
			if(check == 0) count = 0;
			if(check >= 2 || check == 0) break;
			
			count++;
		}
		
		System.out.println(count);
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int count = 0;
			
			if(current.y == N && current.x == M) return;
			
			for(int i=0; i<4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx]) {
					if(sea[ny][nx] == 0) count++;
					else {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
			
			sea[current.y][current.x] -= count;
			if(sea[current.y][current.x] < 0) sea[current.y][current.x] = 0;
		}
	}

	private static boolean isRange(int y, int x) {
		if(y >= 0 && y < N && x >= 0 && x < M) return true;
		return false;
	}
}
