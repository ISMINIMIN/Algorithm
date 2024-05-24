import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] board;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static class Bead {
		int ry;
		int rx;
		int by;
		int bx;
		int count;
		
		public Bead(int ry, int rx, int by, int bx, int count) {
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		Bead start = new Bead(0, 0, 0, 0, 0);
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(board[y][x] == 'R') {
					start.ry = y;
					start.rx = x;
					board[y][x] = '.';
				}
				
				if(board[y][x] == 'B') {
					start.by = y;
					start.bx = x;
					board[y][x] = '.';
				}
			}
		}
		
		System.out.println(bfs(start));
	}

	private static int bfs(Bead start) {
		Queue<Bead> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Bead bead = queue.poll();
			
			if(bead.count == 10) continue;
			
			for(int i=0; i<4; i++) {
				int ry = bead.ry;
				int rx = bead.rx;
				int by = bead.by;
				int bx = bead.bx;
				
				boolean isRed = false;
				boolean isBlue = false;
				
				while(true) {
					int nry = ry + dy[i];
					int nrx = rx + dx[i];
					
					if(board[nry][nrx] == '#') break;
					
					if(board[nry][nrx] == 'O') {
						isRed = true;
						break;
					}
					
					ry = nry;
					rx = nrx;
				}
				
				while(true) {
					int nby = by + dy[i];
					int nbx = bx + dx[i];
					
					if(board[nby][nbx] == '#') break;
					
					if(board[nby][nbx] == 'O') {
						isBlue = true;
						break;
					}
					
					by = nby;
					bx = nbx;
				}
				
				if(isBlue) continue;
				if(isRed) return bead.count + 1;
				
				if(bead.ry == ry && bead.rx == rx && bead.by == by && bead.bx == bx) continue;
				
				if(ry == by && rx == bx) {
					if(i == 0) {
                        if(bead.ry < bead.by) by++;
                        else  ry++;
                    }
                    
                    else if(i == 1) {
                        if(bead.ry < bead.by) ry--;
                        else by--;
                    }
					
                    else if(i == 2) {
                        if(bead.rx < bead.bx) bx++;
                        else rx++;
                    }
                    
                    else if(i == 3) {
                        if(bead.rx < bead.bx) rx--;
                        else bx--;
                    }
				}
				
				queue.add(new Bead(ry, rx, by, bx, bead.count + 1));
			}
		}
		
		return -1;
	}
}
