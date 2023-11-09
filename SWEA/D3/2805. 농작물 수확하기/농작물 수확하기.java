import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j=0; j<N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int count = 0;
			int sum = 0;
			for(int y=0; y<N; y++) {
				for(int x=N/2-count; x<=N/2+count; x++) {
					sum += farm[y][x];
				}
				if(y < N/2) count++;
				else count--;
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}