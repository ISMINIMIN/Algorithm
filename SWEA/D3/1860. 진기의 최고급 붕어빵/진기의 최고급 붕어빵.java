import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int M = Integer.parseInt(st.nextToken()); // 붕어빵 만드는데 걸리는 시간
			int K = Integer.parseInt(st.nextToken()); // 만들 수 있는 붕어빵 수
			int[] times = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(times);
			
			boolean flag = true;
			
			for(int i=1; i<N+1; i++) {
				if(times[i] / M < 1 || (times[i] / M)*K-(i-1) < 1) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("#" + t + " Possible\n");
			else sb.append("#" + t + " Impossible\n");
		}
		
		System.out.println(sb.toString());
	}
}