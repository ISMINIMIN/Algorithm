import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int size = 2;
	static int eat = 0;
	static int count = 0;
	static boolean flag = false;
	
	static int[][] sea;
	static int startY, startX;
	
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
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
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sea = new int[N][N];
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				sea[y][x] = Integer.parseInt(st.nextToken());
				if(sea[y][x] == 9) {
					startY = y;
					startX = x;
					sea[y][x] = 0;
				}
			}
		}
		
		while(true) {
			bfs();
			
			if(!flag) break;
			
			if(size == eat) {
				size++;
				eat = 0;
			}
		}
		
		System.out.println(count);
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) ->
        o1.count != o2.count ? Integer.compare(o1.count, o2.count) : (o1.y != o2.y ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x))
		);
		queue.add(new Node(startY, startX, 0));
		visited[startY][startX] = true;
		
		flag = false;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(sea[node.y][node.x] != 0 && sea[node.y][node.x] < size) {
				sea[node.y][node.x] = 0;
				eat++;
				count += node.count;
				startY = node.y;
				startX = node.x;
				flag = true;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && sea[ny][nx] <= size && !visited[ny][nx]) {
					queue.add(new Node(ny, nx, node.count+1));
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