import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	static int W, H;
	static int[][] island;
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
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) break;
			
			island = new int[H][W];
			visited = new boolean[H][W];
			
			for(int y=0; y<H; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<W; x++) {
					island[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for(int y=0; y<H; y++) {
				for(int x=0; x<W; x++) {
					if(!visited[y][x] && island[y][x] == 1) {
						count++;
						bfs(y, x);
					}
				}
			}
			
			System.out.println(count);
		}
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<8; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx)) {
					if(!visited[ny][nx] && island[ny][nx] == 1) {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

	private static boolean isRange(int y, int x) {
		if(y >= 0 && x >= 0 && y < H && x <W) return true;
		return false;
	}
}
