import java.util.Scanner;

public class Main {
	static int M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		for(int i=1; i<=N; i++) {
			nums[i-1] = i;
		}
		
		recursive(0);
	}

	private static void recursive(int depth) {
		if(depth == M) {
			printResult();
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(!visited[i]) {
				result[depth] = nums[i];
				visited[i] = true;
				recursive(depth+1);
				visited[i] = false;
			}
		}
	}

	private static void printResult() {
		for(int i=0; i<M-1; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println(result[M-1]);
	}
}