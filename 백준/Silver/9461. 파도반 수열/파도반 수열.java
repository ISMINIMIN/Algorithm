import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		long[] P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		
		for(int i=6; i<P.length; i++) {
			P[i] = P[i-5] + P[i-1];
		}
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(P[N]);
		}
	}
}