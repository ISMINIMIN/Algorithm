import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
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
		
		N = Integer.parseInt(br.readLine());
		char[][] rgb = new char[N][N];
		char[][] rb = new char[N][N];
		visited = new boolean[N][N];
		
		for(int y=0; y<N; y++) {
			String line = br.readLine();
			for(int x=0; x<N; x++) {
				char c = line.charAt(x);
				rgb[y][x] = c;
				if(c == 'G') c = 'R';
				rb[y][x] = c;
			}
		}
		
		int count = 0;
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(!visited[y][x]) {
					bfs(rgb, y, x);
					count++;
				}
			}
		}
		
		System.out.print(count + " ");
		
		count = 0;
		visited = new boolean[N][N];
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(!visited[y][x]) {
					bfs(rb, y, x);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	private static void bfs(char[][] arr, int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx] && arr[ny][nx] == arr[y][x]) {
					queue.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < N) return true;
		return false;
	}
}