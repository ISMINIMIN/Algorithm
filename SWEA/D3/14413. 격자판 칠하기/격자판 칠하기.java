import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int cnt;
	static char[][] board;
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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			board = new char[N][M];
			char[][] boardOrid = new char[N][M];
			
			for(int y=0; y<N; y++) {
				String line = br.readLine();
				for(int x=0; x<M; x++) {
					board[y][x] = line.charAt(x);
					boardOrid[y][x] = line.charAt(x);
				}
			}
			
			cnt = 1;
			
			if(board[0][0] == '?') {
				board[0][0] = '.';
				int bfs = bfs(0, 0);
				if(bfs != N*M) {
					cnt = 1;
					board = boardOrid;
					board[0][0] = '#';
					bfs = bfs(0, 0);
					if(bfs == N*M) {
						System.out.println("#" + tc + " possible");
					} else {
						System.out.println("#" + tc + " impossible");
					}
				} else {
					System.out.println("#" + tc + " possible");
				}
			} else {
				if(bfs(0, 0) == N*M) {
					System.out.println("#" + tc + " possible");
				} else {
					System.out.println("#" + tc + " impossible");
				}
			}
		}
	}

	private static int bfs(int y, int x) {
		visited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && !visited[ny][nx]) {
					if(board[node.y][node.x] != board[ny][nx]) {
						queue.add(new Node(ny, nx));
						cnt += 1;
						visited[ny][nx] = true;
						if(board[ny][nx] == '?') {
							if(board[node.y][node.x] == '.') {
								board[ny][nx] = '#';
							} else {
								board[ny][nx] = '.';
							}
						}
					}
				}
			}
		}
		
		return cnt;
	}

	private static boolean isRange(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		return false;
	}
}
