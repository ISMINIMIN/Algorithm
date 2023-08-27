import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long min = Integer.MAX_VALUE;
	static int N;
	static int[][] SB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		SB = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			SB[i][0] = Integer.parseInt(st.nextToken());
			SB[i][1] = Integer.parseInt(st.nextToken());
		}
		
		bit();
		
		System.out.println(min);
	}

	private static void bit() {
		for(int i=1; i<1<<N; i++) {
			long ST = 1;
			long BT = 0;
			for(int j=0; j<N; j++) {
				if((i & 1 <<j) != 0) {
					ST *= SB[j][0];
					BT += SB[j][1];
				}
			}
			
			min = Math.min(Math.abs(ST - BT), min);
		}
	}
}