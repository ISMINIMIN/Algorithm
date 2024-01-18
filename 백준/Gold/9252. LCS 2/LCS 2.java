import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static char[] arr1, arr2;
	static int[][] DP;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		arr1 = new char[str1.length()];
		arr2 = new char[str2.length()];
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = str1.charAt(i);
		}
		
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = str2.charAt(i);
		}
		
		DP = new int[arr1.length+1][arr2.length+1];
		
		lcs();
		getString();
		
		System.out.println(sb.toString());
	}

	private static void getString() {
		Stack<Character> stack = new Stack<>();
		
		int y = arr1.length;
		int x = arr2.length;
		
		while(y > 0 && x > 0) {
			if(y == 0 && x == 0) break;
			
			if(DP[y][x] == DP[y-1][x]) y--;
			else if(DP[y][x] == DP[y][x-1]) x--;
			else {
				y--;
				x--;
				stack.push(arr1[y]);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}

	private static void lcs() {
		for(int i=1; i<=arr1.length; i++) {
			for(int j=1; j<=arr2.length; j++) {
				if(arr1[i-1] == arr2[j-1]) DP[i][j] = DP[i-1][j-1] + 1;
				else DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
			}
		}
		
		sb.append(DP[arr1.length][arr2.length]).append("\n");
	}
}
