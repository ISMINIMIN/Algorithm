import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		dfs(0);
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		int temp = 0;
		for(int i=0; i<N; i++) {
			if(!visited[i] && temp != nums[i]) {
				result[depth] = nums[i];
				visited[i] = true;
				temp = nums[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}