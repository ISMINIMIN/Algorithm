import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static String origin;
	static Queue<Character> queue;
	static StringBuilder result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();
		
		origin = br.readLine();
		
		boolean isJava = false;
		boolean isCpp = false;
		boolean isPossible = true;
		
		queue = new LinkedList<>();
		for(int i=0; i<origin.length(); i++) {
			char temp = origin.charAt(i);
			queue.add(temp);
			
			if(i == 0) {
				if(temp == '_' || (temp >= 'A' && temp <= 'Z')) {
					isPossible = false;
					break;
				}
			}
			
			if(i == origin.length() - 1) {
				if(temp == '_') {
					isPossible = false;
					break;
				}
			}
			
			if(temp >= 'A' && temp <= 'Z') isJava = true;
			if(temp == '_') {
				if(origin.charAt(i+1) == '_') isPossible = false;
				isCpp = true;
			}
		}
		
		if(isCpp && isJava || !isPossible) result.append("Error!");
		else if(!isCpp && !isJava) result.append(origin);
		else changeVarName();
		
		System.out.println(result.toString());
	}

	private static void changeVarName() {
		while(!queue.isEmpty()) {
			char temp = queue.poll();
			
			if(temp == '_') {
				temp = queue.poll();
				temp -= 32;
			} else if(temp >= 'A' && temp <= 'Z') {
				result.append("_");
				temp += 32;
			}
			
			result.append(temp);
		}
	}
}
