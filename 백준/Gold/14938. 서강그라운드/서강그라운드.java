import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		int[] items = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int pri = Integer.parseInt(st.nextToken());
			map[start][end] = pri;
			map[end][start] = pri;
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(map[i][j] == 0 && i != j) map[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(map[i][k] + map[k][j] < map[i][j]) map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int result = 0;
		for(int i=1; i<N+1; i++) {
			int sum = 0;
			for(int j=1; j<N+1; j++) {
				if(map[i][j] <= M) sum += items[j];
			}
			result = Math.max(result, sum);
		}
		
		System.out.println(result);
	}
}