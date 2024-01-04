import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		result = new int[M];
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}
		
		dfs(0, 0);
	}

	private static void dfs(int depth, int idx) {
		if(depth == M) {
			for(int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			result[depth] = nums[i];
			dfs(depth + 1, i);
		}
	}
}
