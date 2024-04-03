import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static class Operator {
		char value;
		int priority;
		
		public Operator(char value) {
			this.value = value;
			priority = setPriority(value);
		}

		private int setPriority(char value) {
			if(value == '*' || value == '/') return 1;
			if(value == '+' || value == '-') return 0;
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Operator> stack = new Stack<>();
		String line = br.readLine();
		
		for(int i=0; i<line.length(); i++) {
			char temp = line.charAt(i);
			Operator operator;
			
			switch (temp) {
			case '+':
			case '-':
			case '*':
			case '/':
				operator = new Operator(temp);
				while(!stack.isEmpty() && operator.priority <= stack.peek().priority) {
					sb.append(stack.pop().value);
				}
				stack.add(operator);
				break;
			case '(':
				operator = new Operator(temp);
				stack.add(operator);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek().value != '(') {
					sb.append(stack.pop().value);
				}
				stack.pop();
				break;
			default:
				sb.append(temp);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop().value);
		}
		
		System.out.println(sb.toString());
	}
}
