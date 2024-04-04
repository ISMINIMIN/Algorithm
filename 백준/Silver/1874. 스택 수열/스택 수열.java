import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int num = 1;
		
		for(int i=0; i<N; i++) {
			int target = Integer.parseInt(br.readLine());
			
			while(num <= target) {
				stack.push(num++);
				sb.append("+").append("\n");
			}
			
			if(stack.peek() != target) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
