import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String line = sc.nextLine();
			
			if(line.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '(' || c == '[') stack.push(c);
				
				if(c == ')' || c == ']') {
					if(stack.isEmpty() || (c == ')' && stack.peek() == '[') || (c == ']' && stack.peek() == '(')) {
						stack.push(c);
						break;
					}
					
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}