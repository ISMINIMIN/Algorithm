import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];
		
		int r = 0;
		int g = 1;
		int b = 2;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i][r] = Integer.parseInt(st.nextToken());
			dp[i][g] = Integer.parseInt(st.nextToken());
			dp[i][b] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			dp[i][r] += Math.min(dp[i-1][g], dp[i-1][b]);
			dp[i][g] += Math.min(dp[i-1][r], dp[i-1][b]);
			dp[i][b] += Math.min(dp[i-1][r], dp[i-1][g]);
		}
		
		System.out.println(Math.min(dp[N-1][r], Math.min(dp[N-1][g], dp[N-1][b])));
	}
}