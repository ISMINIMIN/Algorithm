import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i == j) continue;
				distance[i][j] = 1_000_000_000;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		
		floyd();
		
		int result = Integer.MAX_VALUE;
		int store1 = 0;
		int store2 = 0;
		
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<N+1; j++) {
				int temp = 0;
				
				for(int k=1; k<N+1; k++) {
					if(i == k || j == k) continue;
					temp += Math.min(distance[i][k], distance[j][k]);
				}
				
				if(temp < result) {
					result = temp;
					store1 = i;
					store2 = j;
				}
			}
		}
		
		sb.append(store1).append(" ").append(store2).append(" ").append(result * 2);
		System.out.println(sb.toString());
	}

	private static void floyd() {
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
	}
}
