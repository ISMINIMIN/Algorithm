import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int days = 0;
	static int[][][] box;
	static boolean[][][] visited;
	
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dx = {0, 0, -1, 1, 0, 0};
	
	static class Node {
		int z;
		int x;
		int y;
		int days;
		
		public Node(int z, int x, int y, int days) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.days = days;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][M][N];
		visited = new boolean[H][M][N];
		
		ArrayList<Node> list = new ArrayList<>();
		
		for(int z=0; z<H; z++) {
			for(int x=0; x<M; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<N; y++) {
					box[z][x][y] = Integer.parseInt(st.nextToken());
					if(box[z][x][y] == 1) list.add(new Node(z, x, y, 0));
				}
			}
		}
		
		bfs(list);
		
		for(int z=0; z<H; z++) {
			for(int x=0; x<M; x++) {
				for(int y=0; y<N; y++) {
					if(box[z][x][y] == 0) {
						days = -1;
						break;
					}
				}
			}
		}
		
		System.out.println(days);
	}

	private static void bfs(ArrayList<Node> list) {
		Queue<Node> queue = new LinkedList<>();
		for(Node node : list) {
			queue.add(node);
			visited[node.z][node.x][node.y] = true;
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			days = Math.max(days, node.days);
			
			for(int i=0; i<6; i++) {
				int nz = node.z + dz[i];
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(isRange(nz, nx, ny) && !visited[nz][nx][ny] && box[nz][nx][ny] == 0) {
					queue.add(new Node(nz, nx, ny, node.days+1));
					visited[nz][nx][ny] = true;
					box[nz][nx][ny] = 1;
				}
			}
		}
	}

	private static boolean isRange(int nz, int nx, int ny) {
		if(nz >= 0 && ny >= 0 && nx >= 0 && nz < H && nx < M && ny < N) return true;
		return false;
	}
}