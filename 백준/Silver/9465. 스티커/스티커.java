import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][N+2];
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=2; j<N+2; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=2; i<N+2; i++) {
				dp[0][i] = Math.max(dp[0][i] + dp[0][i-2], Math.max(dp[0][i] + dp[1][i-2], dp[0][i] + dp[1][i-1]));
				dp[1][i] = Math.max(dp[1][i] + dp[1][i-2], Math.max(dp[1][i] + dp[0][i-2], dp[1][i] + dp[0][i-1]));
			}
			
			System.out.println(Math.max(dp[0][N+1], dp[1][N+1]));
		}
	}
}