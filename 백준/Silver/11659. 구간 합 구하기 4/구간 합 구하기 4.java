import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] nums = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			nums[i] = nums[i-1] + sc.nextInt();
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(nums[end] - nums[start-1]);
		}
	}
}