import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] mbti = new String[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				mbti[i] = st.nextToken();
			}
			
			if(N > 32) {
				System.out.println(0);
			} else {
				int min = Integer.MAX_VALUE;
				for(int i=0; i<N-2; i++) {
					for(int j=i+1; j<N-1; j++) {
						for(int k=j+1; k<N; k++) {
							int count = 0;
							for(int q=0; q<4; q++) {
								char c1 = mbti[i].charAt(q);
								char c2 = mbti[j].charAt(q);
								char c3 = mbti[k].charAt(q);
								
								if(c1 != c2) count++;
								if(c2 != c3) count++;
								if(c1 != c3) count++;
							}
							min = Math.min(min, count);
						}
					}
				}
				
				System.out.println(min);
			}
		}
	}
}