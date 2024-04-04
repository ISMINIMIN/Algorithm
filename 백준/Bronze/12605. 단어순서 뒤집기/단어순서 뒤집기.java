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
		Stack<String> stack = new Stack<>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("Case #").append(t).append(":");
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				stack.push(st.nextToken());
			}
			
			while(!stack.isEmpty()) {
				sb.append(" ").append(stack.pop());
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
