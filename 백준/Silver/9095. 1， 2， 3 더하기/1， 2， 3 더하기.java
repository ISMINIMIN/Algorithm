import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] DP = new int[12];
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		for(int i=4; i<DP.length; i++) {
			DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
		}
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(DP[num]);
		}
	}
}