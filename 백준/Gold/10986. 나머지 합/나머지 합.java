import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] sum = new long[N+1];
		long[] remainderCount = new long[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
			remainderCount[(int)(sum[i]%M)]++;
		}
		
		long result = remainderCount[0];
		for(int i=0; i<M; i++) {
			if(remainderCount[i] != 0) {
				result += (remainderCount[i] * (remainderCount[i]-1)) / 2;
			}
		}
		
		System.out.println(result);
	}
}
