import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int max = 0;
	static int[] cards;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		combine(0, 0, 0);
		
		System.out.println(max);
	}

	private static void combine(int depth, int now, int sum) {
		if(sum > M) return;
		
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=now; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combine(depth+1, i+1, sum+cards[i]);
				visited[i] = false;
			}
		}
	}
}
