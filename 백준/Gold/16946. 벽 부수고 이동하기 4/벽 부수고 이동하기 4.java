import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M, idx;
	static int[][] map, group, result;
	static Map<Integer, Integer> groups = new HashMap<>();
	
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
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		group = new int[N][M];
		result = new int[N][M];
		
		for(int y=0; y<N; y++) {
			String line = br.readLine();
			for(int x=0; x<M; x++) {
				map[y][x] = line.charAt(x) - '0';
			}
		}
		
		idx = 1;
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(map[y][x] == 0 && group[y][x] == 0) {
					bfs(y, x);
					idx++;
				}
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(map[y][x] == 1) {
					int cnt = 1;
					Set<Integer> idxs = new HashSet<>();
					
					for(int i=0; i<4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						
						if(isRange(ny, nx) && group[ny][nx] != 0) {
							idxs.add(group[ny][nx]);
						}
					}
					
					for(int i: idxs) {
						cnt += groups.get(i);
					}
					
					result[y][x] = cnt % 10;
				}
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				sb.append(result[y][x]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		int cnt = 1;
		
		queue.add(new Node(y, x));
		group[y][x] = idx;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && group[ny][nx] == 0) {
					if(map[ny][nx] == 0) {
						queue.add(new Node(ny, nx));
						group[ny][nx] = idx;
						cnt++;
					}
				}
			}
		}
		
		groups.put(idx, cnt);
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}
}
