import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] students = new int[N];
		int[] diff = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
			if(i != 0) diff[i-1] = students[i] - students[i-1];
		}
		
		Arrays.sort(diff);
		
		int result = 0;
		for(int i=0; i<N-K; i++) {
			result += diff[i];
		}
		
		System.out.println(result);
	}
}
