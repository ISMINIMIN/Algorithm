import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] sums = new int[N+1];
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sums[i] = sums[i-1] + temp;
			if(sums[i] >= S) {
				flag = true;
				min = Math.min(min, i);
			}
		}
		
		int start = 0;
		int end = 0;
		while(true) {
			if(start > end || end > N) break;
			
			if(sums[end] - sums[start] < S) end++;
			else {
				flag = true;
				min = Math.min(min, end-start);
				start++;
			}
		}
		
		if(flag) System.out.println(min);
		else System.out.println(0);
	}
}