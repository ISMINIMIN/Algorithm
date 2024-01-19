import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int N, K, L;
	static int[][] board;
	static int dir = 1;
	static int time = 0;
	
	static TreeMap<Integer, Character> map = new TreeMap<>();
	
	static class Node {
		int y;
		int x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		dummy();
		
		System.out.println(time);
	}

	private static void dummy() {
		int y = 1;
		int x = 1;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		board[y][x] = -1;
		
		while(true) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			time++;
			
			if(!isRange(ny, nx) || board[ny][nx] == -1) break;
			
			if(board[ny][nx] == 0) {
				Node node = queue.poll();
				board[node.y][node.x] = 0;
			}
			
			if(!map.isEmpty()) {
				if(time == map.firstKey()) {
					if(map.get(map.firstKey()) == 'L') {
						dir--;
						if(dir < 0) dir = 3;
					} else {
						dir++;
						if(dir > 3) dir = 0;
					}
					map.remove(map.firstKey());
				}
			}
			
			board[ny][nx] = -1;
			queue.add(new Node(ny, nx));
			y = ny;
			x = nx;
		}
	}

	private static boolean isRange(int y, int x) {
		if(y > 0 && x > 0 && y <= N && x <= N) return true;
		return false;
	}
}
