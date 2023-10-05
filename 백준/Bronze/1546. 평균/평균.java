import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		double max = 0;
		double sum = 0;
		double[] scores = new double[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			if(scores[i] > max) max = scores[i];
		}
		
		for(int i=0; i<N; i++) {
			scores[i] = scores[i] / max * 100;
			sum += scores[i];
		}
		
		System.out.println(sum / N);
	}
}