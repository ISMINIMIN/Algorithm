import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		dp = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp();
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[start][end]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dp() {
		for(int i=1; i<N+1; i++) {
			dp[i][i] = 1;
			if(nums[i-1] == nums[i]) dp[i-1][i] = 1;
		}
		
		for(int i=2; i<N; i++) {
			for(int j=1; j<N-i+1; j++) {
				if(nums[j] == nums[j+i] && dp[j+1][j+i-1] == 1) dp[j][i+j] = 1;
			}
		}
	}
}
