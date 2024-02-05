import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] result = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			result[i] = -1;
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				int idx = stack.pop();
				result[idx] = nums[i];
			}
			stack.push(i);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
