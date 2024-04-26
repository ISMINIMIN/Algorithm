import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] wines;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		wines = new int[N+1];
		dp = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		dp();
		
		System.out.println(dp[N]);
	}

	private static void dp() {
		dp[1] = wines[1];
		
		if(N == 1) return;
		
		dp[2] = wines[1] + wines[2];
		
		for(int i=3; i<N+1; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wines[i-1]) + wines[i]);
		}
	}
}
