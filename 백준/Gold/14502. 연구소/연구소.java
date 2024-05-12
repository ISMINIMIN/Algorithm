import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int BLANK = 0;
	static final int WALL = 1;
	static final int VIRUS = 2;
	static final int MAX_NEW_WALL = 3;
	
	static int virusCnt = Integer.MAX_VALUE;
	static int N, M, blankCnt;
	static int[][] lab;
	static List<Node> viruses;
	
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
		
		lab = new int[N][M];
		viruses = new ArrayList<>();
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				lab[y][x] = Integer.parseInt(st.nextToken());
				if(lab[y][x] == VIRUS) viruses.add(new Node(y, x));
				if(lab[y][x] == BLANK) blankCnt++;
			}
		}
		
		dfs(0);
		
		System.out.println(blankCnt - virusCnt - MAX_NEW_WALL);
	}
	
	private static void dfs(int depth) {
		if(depth == MAX_NEW_WALL) {
			bfs();
			return;
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(lab[y][x] == BLANK) {
					lab[y][x] = WALL;
					dfs(depth + 1);
					lab[y][x] = BLANK;
				}
			}
		}
	}

	private static void bfs() {
		int newVirus = 0;
		Queue<Node> queue = new LinkedList<>();
		
		int[][] tempLab = new int[N][M];
		for(int i=0; i<N; i++) {
			tempLab[i] = lab[i].clone();
		}
		
		for(Node virus : viruses) {
			queue.add(virus);
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(newVirus > virusCnt) break;
			
			for(int i=0; i<4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(isRange(ny, nx)) {
					if(tempLab[ny][nx] == BLANK) {
						queue.add(new Node(ny, nx));
						tempLab[ny][nx] = VIRUS;
						newVirus++;
					}
				}
			}
		}
		
		virusCnt = Math.min(virusCnt, newVirus);
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}
}
