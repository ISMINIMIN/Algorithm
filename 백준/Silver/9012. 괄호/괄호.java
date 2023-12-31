import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			Stack<Character> stack = new Stack<>();
			String line = br.readLine();
			
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '(') stack.push(c);
				else {
					if(stack.isEmpty()) {
						stack.push(c);
						break;
					}
					else stack.pop();
				}
			}
			
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
