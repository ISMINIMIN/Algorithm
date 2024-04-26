import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int K, N;
	static final int MAX = 15;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			K = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			
			sb.append(dp[K][N]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dp() {
		dp = new int[MAX][MAX];
		
		for(int i=0; i<MAX; i++) {
			dp[0][i] = i;
			dp[i][1] = 1;
		}
		
		for(int i=1; i<MAX; i++) {
			for(int j=2; j<MAX; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
	}
}
