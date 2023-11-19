import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(checker(str)) result++;
		}
		
		System.out.println(result);
	}

	private static boolean checker(String str) {
		ArrayList<Character> list = new ArrayList<>();
		list.add(str.charAt(0));
		
		for(int i=0; i<str.length()-1; i++) {
			char front = str.charAt(i);
			char back = str.charAt(i+1);
			
			if(front != back) {
				if(list.contains(back)) return false;
				list.add(back);
			}
		}
		return true;
	}
}