import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int nums[][] = new int[N+1][N+1];
		int DP[][] = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + nums[i][j];
			}
		}
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			max = Math.max(max, DP[N][i]);
		}
		
		System.out.println(max);
	}
}
