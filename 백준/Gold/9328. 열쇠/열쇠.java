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
	
	static int count, h, w;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] keys;
	static ArrayList<Node>[] gates;
	
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
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			keys = new boolean[26];
			gates = new ArrayList[26];
			
			for(int i=0; i<26; i++) {
				gates[i] = new ArrayList<>();
			}
			
			for(int i=0; i<h+2; i++) {
				for(int j=0; j<w+2; j++) {
					map[i][j] = '.';
				}
			}
			
			for(int i=1; i<=h; i++) {
				String line = br.readLine();
				for(int j=1; j<=w; j++) {
					map[i][j] = line.charAt(j-1);
				}
			}
			
			String line = br.readLine();
			if(!line.equals("0")) {
				for(int i=0; i<line.length(); i++) {
					keys[line.charAt(i) - 'a'] = true;
				}
			}
			
			count = 0;
			bfs();
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx) && map[ny][nx] != '*' && !visited[ny][nx]) {
					char next = map[ny][nx];
					
					if(next - 'A' >= 0 && next - 'A' < 26) {
						if(keys[next - 'A']) map[ny][nx] = '.';
						else {
							gates[next - 'A'].add(new Node(ny, nx));
							continue;
						}
					}
					
					else if(next - 'a' >= 0 && next - 'a' < 26) {
						keys[next - 'a'] = true;
						
						for(int j=0; j<26; j++) {
							if(gates[j].size() != 0 && keys[j]) {
								for(int k=0; k<gates[j].size(); k++) {
									Node temp = gates[j].get(k);
									map[temp.y][temp.x] = '.';
									queue.add(new Node(temp.y, temp.x));
									visited[temp.y][temp.x] = true;
								}
							}
						}
					}
					
					else if(next == '$') {
						count++;
						map[ny][nx] = '.';
					}
					
					queue.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && y < h+2 && x >= 0 && x < w+2;
	}
}
