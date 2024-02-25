import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max = 0;
	static int[] nums, temp;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		temp = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max);
	}

	private static void dfs(int depth) {
		if(depth == N) {
			int sum = 0;
			
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(temp[i] - temp[i+1]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				temp[depth] = nums[i];
				visited[i] = true;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
