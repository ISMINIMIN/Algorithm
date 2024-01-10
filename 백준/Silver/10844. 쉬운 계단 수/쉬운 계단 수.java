import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000000;
		
		long[][] DP = new long[N+1][10];
		
		for(int i=1; i<10; i++) {
			DP[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			DP[i][0] = DP[i-1][1] % mod;
			DP[i][9] = DP[i-1][8] % mod;
			for(int j=1; j<=8; j++) {
				DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % mod;
			}
		}
		
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum += DP[N][i];
		}
		
		System.out.println(sum % mod);
	}
}
