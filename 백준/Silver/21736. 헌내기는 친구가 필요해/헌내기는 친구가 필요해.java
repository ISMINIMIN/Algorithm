import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] campus;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		campus = new char[N][M];
		visited = new boolean[N][M];
		Node node = null;
		
		for(int y=0; y<N; y++) {
			String line = br.readLine();
			for(int x=0; x<M; x++) {
				char c = line.charAt(x);
				campus[y][x] = c;
				if(c == 'I') node = new Node(y, x);
			}
		}
		
		int answer = bfs(node);
		if(answer == 0) System.out.println("TT");
		else System.out.println(answer);
	}

	private static int bfs(Node start) {
		int count = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		visited[start.y][start.x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx] && campus[ny][nx] != 'X') {
					queue.add(new Node(ny, nx));
					visited[ny][nx] = true;
					if(campus[ny][nx] == 'P') count++;
				}
			}
		}
		
		return count;
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		return false;
	}
}