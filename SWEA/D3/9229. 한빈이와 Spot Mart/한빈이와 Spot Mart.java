import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snacks = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i=0; i<snacks.length; i++) {
				for(int j=i+1; j<snacks.length; j++) {
					int sum = snacks[i] + snacks[j];
					int c_max = Math.max(max, sum);
					if(c_max <= M) max = c_max;
				}
			}
			
			if(max == 0) System.out.println("#" + t + " -1");
			else System.out.println("#" + t + " " + max);
		}
    }
}