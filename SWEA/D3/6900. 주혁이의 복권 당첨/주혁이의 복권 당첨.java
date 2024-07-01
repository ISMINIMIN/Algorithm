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
			
			String[][] lottos = new String[N][2];
			String[] nums = new String[M];
			boolean flag;
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				lottos[i][0] = st.nextToken();
				lottos[i][1] = st.nextToken();
			}
			
			for(int i=0; i<M; i++) {
				nums[i] = br.readLine();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					flag = true;
					for(int k=0; k<8; k++) {
						if(lottos[i][0].charAt(k) == '*') continue;
						else {
							if(lottos[i][0].charAt(k) != nums[j].charAt(k)) {
								flag = false;
								break;
							}
						}
					}
					if(flag) sum += Integer.parseInt(lottos[i][1]);
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
    }
}