import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static final int HOME = 1;
	static final int STORE = 2;
	
	static int min = Integer.MAX_VALUE;
	static int N, M;
	static int[][] city;
	static boolean[] pick;
	static List<Node> homes, stores;
	
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
		
		city = new int[N+1][N+1];
		homes = new ArrayList<>();
		stores = new ArrayList<>();
		
		for(int y=1; y<N+1; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=1; x<N+1; x++) {
				city[y][x] = Integer.parseInt(st.nextToken());
				if(city[y][x] == HOME) homes.add(new Node(y, x));
				if(city[y][x] == STORE) stores.add(new Node(y, x));
			}
		}
		
		pick = new boolean[stores.size()];
		dfs(0, 0);
		
		System.out.println(min);
	}

	private static void dfs(int depth, int now) {		
		if(depth == M) {
			calculateDistance();
			return;
		}

		for(int i=now; i<stores.size(); i++) {
			pick[i] = true;
			dfs(depth + 1, i + 1);
			pick[i] = false;
		}
	}
	
	private static void calculateDistance() {
		int distance = 0;
		
		for(Node home : homes) {
			int tempDistance = Integer.MAX_VALUE;
			
			for(int i=0; i<stores.size(); i++) {
				if(pick[i]) {
					Node store = stores.get(i);
					int temp = Math.abs(home.y - store.y) + Math.abs(home.x - store.x);
					tempDistance = Math.min(tempDistance, temp);
				}
			}
			
			distance += tempDistance;
			if(distance > min) break;
		}
		
		min = Math.min(min, distance);
	}
}
