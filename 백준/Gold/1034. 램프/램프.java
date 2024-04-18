import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int max = 0;
	static int[] offCnt;
	static String[] lamps;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		offCnt = new int[N];
		lamps = new String[N];
		check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			lamps[i] = br.readLine();
			for(int j=0; j<M; j++) {
				if(lamps[i].charAt(j) == '0') offCnt[i]++;
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		checkLamp();
		
		System.out.println(max);
	}

	private static void checkLamp() {
		for(int i=0; i<N; i++) {
			if(check[i]) continue;
			
			if(offCnt[i] <= K && (K - offCnt[i]) % 2 == 0) {
				int sameLine = 0;
				for(int j=0; j<N; j++) {
					if(lamps[i].equals(lamps[j])) {
						sameLine++;
						check[j] = true;
					}
				}
				
				max = Math.max(max, sameLine);
			}
		}
	}
}
