import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			queue.add(num);
		}
		
		while(queue.size() != 1) {
			int num1 = queue.poll();
			int num2 = queue.poll();
			result += num1 + num2;
			queue.add(num1 + num2);
		}
		
		System.out.println(result);
	}
}