import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] liquids = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int[] result = new int[2];
		int start = 0;
		int end = N-1;
		
		while(true) {
			if(start >= end) break;
			
			int temp = liquids[end] + liquids[start];
			int abs = Math.abs(0 - temp);
			if(min > abs) {
				min = abs;
				result[0] = liquids[start];
				result[1] = liquids[end];
				
			}
			
			if(temp < 0) start++;
			else end--;
		}
		
		System.out.println(result[0] + " " + result[1]);
	}
}