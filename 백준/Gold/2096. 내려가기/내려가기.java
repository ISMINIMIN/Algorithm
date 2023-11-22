import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N  = Integer.parseInt(br.readLine());
		int[] min = new int[3];
		int[] max = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			min[i] = max[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			int tempMin0 = min[0];
			int tempMin2 = min[2];
			min[0] = Math.min(min[0], min[1]) + num1;
			min[2] = Math.min(min[1], min[2]) + num3;
			min[1] = Math.min(tempMin0, Math.min(tempMin2, min[1])) + num2;
			
			int tempMax0 = max[0];
			int tempMax2 = max[2];
			max[0] = Math.max(max[0], max[1]) + num1;
			max[2] = Math.max(max[1], max[2]) + num3;
			max[1] = Math.max(tempMax0, Math.max(tempMax2, max[1])) + num2;
		}
		
		int totalMin = Math.min(min[0], Math.min(min[1], min[2]));
		int totalMax = Math.max(max[0], Math.max(max[1], max[2]));
		
		System.out.println(totalMax + " " + totalMin);
	}
}