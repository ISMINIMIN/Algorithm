import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N];
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = i+1;
		}

		dfs(0);
	}

	private static void dfs(int depth) {
		if(depth == N) {
			int count = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) count++;
			}
			
			if(count == M) print();
			return;
		}
		
		visited[depth] = true;
		dfs(depth+1);
		
		visited[depth] = false;
		dfs(depth+1);
	}

	private static void print() {
		for(int i=0; i<N; i++) {
			if(visited[i]) System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}