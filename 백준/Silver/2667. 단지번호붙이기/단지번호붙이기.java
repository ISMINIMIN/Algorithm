import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> counts = new ArrayList<>();
	
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
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N][N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(map[y][x] == 1 && !visited[y][x]) {
					bfs(y, x);
				}
			}
		}
		
		Collections.sort(counts);
		System.out.println(counts.size());
		for(int count : counts) {
			System.out.println(count);
		}
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(ny >= 0 && nx >= 0 && ny < N && nx < N) {
					if(!visited[ny][nx] && map[ny][nx] == 1) {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
						count++;
					}
				}
			}
		}
		
		counts.add(count);
	}
}