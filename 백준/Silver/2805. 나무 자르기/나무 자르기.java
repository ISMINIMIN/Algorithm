import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		
		int max = 0;
		int min = 0;
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		while(true) {
			if(min > max) break;
			
			int mid = (min + max) / 2;
			long sum = 0;
			
			for(int i=0; i<N; i++) {
				if(trees[i] < mid) continue;
				sum += trees[i] - mid;
			}
			
			if(sum < M) max = mid - 1;
			else {
				min = mid + 1;
				answer = Math.max(answer, mid);
			}
		}
		
		System.out.println(answer);
	}
}