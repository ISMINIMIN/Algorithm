import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] buildings = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			double target = 0;
			int cnt = 0;
			
			for(int j=i-1; j>=0; j--) {
				double temp = calc(j, buildings[j], i, buildings[i]);
				if(j == i-1 || temp < target) {
					cnt++;
					target = temp;
				}
			}
			
			for(int j=i+1; j<N; j++) {
				double temp = calc(j, buildings[j], i, buildings[i]);
				if(j == i+1 ||temp > target) {
					cnt++;
					target = temp;
				}
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}

	private static double calc(int x1, int y1, int x2, int y2) {
		return (double)(y2 - y1) / (x2 - x1);
	}
}
