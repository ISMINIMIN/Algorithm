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
		
		int[] sizes = new int[N];
		int[] costs = new int[N];
		int[] dp = new int[10001]; // 100^2 = 10000
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=10000; j>=costs[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-costs[i]] + sizes[i]);
			}
		}
		
		for(int i=0; i<10001; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}
