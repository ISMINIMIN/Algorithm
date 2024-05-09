import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {0, -1, 0, 1}; // 우상좌하
	static int[] dx = {1, 0, -1, 0};
	static boolean[][] map;
	
	static final int LEN = 101;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new boolean[LEN][LEN];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			dragonCurve(x, y, d, g);
		}
		
		System.out.println(countSquare());
	}

	private static void dragonCurve(int x, int y, int d, int g) {
		List<Integer> directions = new ArrayList<>();
		directions.add(d);
		
		for(int i=0; i<g; i++) {
			for(int j=directions.size()-1; j>=0; j--) {
				directions.add((directions.get(j) + 1) % 4);
			}
		}
		
		map[y][x] = true;
		for(int direction : directions) {
			y += dy[direction];
			x += dx[direction];
			map[y][x] = true;
		}
	}
	
	private static int countSquare() {
		int count = 0;
		
		for(int y=0; y<LEN-1; y++) {
			for(int x=0; x<LEN-1; x++) {
				if(isSquare(y, x)) count++;
			}
		}
		
		return count;
	}
	
	private static boolean isSquare(int y, int x) {
		return map[y][x] && map[y+1][x] && map[y][x+1] && map[y+1][x+1];
	}
}
