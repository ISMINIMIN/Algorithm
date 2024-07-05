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
			int D = Integer.parseInt(st.nextToken());
			
			int[] doors = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				doors[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			int move = 0;
			
			if(doors[0] == 0) {
				count++;
				doors[0] = 1;
			}
			if(doors[N-1] == 0) {
				count++;
				doors[N-1] = 1;
			}
			
			for(int i=0; i<doors.length; i++) {
				if(doors[i] == 1) move = 0;
				else {
					move++;
					if(move == D) {
						count++;
						move = 0;
					}
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
    }
}