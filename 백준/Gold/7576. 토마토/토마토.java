import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int[][] box;
	static boolean[][] visited;
	static int M, N;
	static int days = 0;
	
	static class Node{
		int y;
		int x;
		int days;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public Node(int y, int x, int days) {
			this.y = y;
			this.x = x;
			this.days = days;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		visited = new boolean[N][M];
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				box[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Node> list = new ArrayList<>();
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(box[y][x] == 1) {
					list.add(new Node(y, x));
				}
			}
		}
		
		bfs(list);
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(box[y][x] == 0) {
					days = -1;
					break;
				}
			}
		}
		
		System.out.println(days);
	}

	private static void bfs(ArrayList<Node> list) {
		Queue<Node> queue = new LinkedList<>();
		for(Node nodeList : list) {
			queue.add(new Node(nodeList.y, nodeList.x, 0));
			visited[nodeList.y][nodeList.x] = true;
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			days = Math.max(days, node.days);
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && box[ny][nx] == 0 && !visited[ny][nx]) {
					queue.add(new Node(ny, nx, node.days+1));
					visited[ny][nx] = true;
					box[ny][nx] = 1;
				}
			}
		}
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		return false;
	}
}