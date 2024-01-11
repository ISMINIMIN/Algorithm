import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		int[] DP = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[0] = 1;
		
		for(int i=1; i<N; i++) {
			DP[i] = 1;
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i] && DP[i] <= DP[j]) {
					DP[i] = DP[j] + 1;
				}
			}
		}
		
		int max = 0;
		for(int dp : DP) {
			max = Math.max(max, dp);
		}
		
		System.out.println(max);
	}
}
