import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] levels = new int[n];
		int delete = (int)(Math.round(n * 0.15));
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			levels[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(levels);
		
		for(int i=delete; i<n-delete; i++) {
			sum += levels[i];
		}
		
		int answer = (int)Math.round(sum / (n - delete * 2.0));
		
		System.out.println(answer);
	}
}