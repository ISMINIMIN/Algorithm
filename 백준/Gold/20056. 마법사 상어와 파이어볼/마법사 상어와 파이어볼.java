import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, sum;
	static Queue<Fireball>[][] board;
	
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int[] even = {0, 2, 4, 6};
	static int[] odd = {1, 3, 5, 7};
	
	static class Fireball {
		int y;
		int x;
		int m;
		int s;
		int d;
		
		public Fireball(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
		public Fireball(int y, int x, int m, int s, int d) {
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new LinkedList[N+1][N+1];
		
		for(int y=1; y<N+1; y++) {
			for(int x=1; x<N+1; x++) {
				board[y][x] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			board[y][x].add(new Fireball(m, s, d));
		}
		
		while(true) {
			if(K == 0) break;
			
			move();
			merge();
			
			K--;
		}
		
		sum = 0;
		for(int y=1; y<N+1; y++) {
			for(int x=1; x<N+1; x++) {
				while(!board[y][x].isEmpty()) {
					Fireball fireball = board[y][x].poll();
					sum += fireball.m;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	private static void move() {
		List<Fireball> tempList = new ArrayList<>();
		
		for(int y=1; y<N+1; y++) {
			for(int x=1; x<N+1; x++) {
				while(!board[y][x].isEmpty()) {
					Fireball fireball = board[y][x].poll();
					
					int ny = y + dy[fireball.d] * (fireball.s % N);
					int nx = x + dx[fireball.d] * (fireball.s % N);
					
					if(ny < 1) ny += N;
					if(nx < 1) nx += N;
					if(ny > N) ny -= N;
					if(nx > N) nx -= N;
					
					fireball.y = ny;
					fireball.x = nx;
					
					tempList.add(fireball);
				}
			}
		}
		
		for(Fireball fireball : tempList) {
			board[fireball.y][fireball.x].add(fireball);
		}
	}

	private static void merge() {
		for(int y=1; y<N+1; y++) {
			for(int x=1; x<N+1; x++) {
				if(board[y][x].size() < 2) continue;
				
				int m = 0;
				int s = 0;
				boolean o = true;
				boolean e = true;
				int cnt = board[y][x].size();
				
				while(!board[y][x].isEmpty()) {
					Fireball fireball = board[y][x].poll();
					
					m += fireball.m;
					s += fireball.s;
					
					if(fireball.d % 2 == 0) o = false;
					else e = false;
				}
				
				m /= 5;
				s /= cnt;
				
				if(m == 0) continue;
				
				for(int i=0; i<4; i++) {
					if(e || o) board[y][x].add(new Fireball(m, s, even[i]));
					else board[y][x].add(new Fireball(m, s, odd[i]));
				}
			}
		}
	}
}
