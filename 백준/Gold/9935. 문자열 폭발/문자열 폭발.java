import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<String> stack = new Stack<>();
		
		String str = br.readLine();
		String[] strArray = str.split("");
		String bomb = br.readLine();
		String[] bombArray = bomb.split("");
		
		for(int i=0; i<strArray.length; i++) {
			stack.push(strArray[i]);
			
			if(strArray[i].equals(bombArray[bombArray.length-1])) {
				boolean flag = true;
				int len = stack.size()-bombArray.length;
				
				if(len >= 0) {
					for(int j=0; j<bombArray.length; j++) {
						if(!bombArray[j].equals(stack.get(len+j))) {
							flag = false;
							break;
						}
					}
				} else flag = false;
				
				if(flag) {
					for(int j=0; j<bombArray.length; j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) sb.append("ALURF");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().toString());
	}
}