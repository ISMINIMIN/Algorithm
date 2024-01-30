import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int count = 0;
		
		if(str1.length() == str2.length()) {
			for(int i=0; i<str1.length(); i++) {
				if(str1.charAt(i) == str2.charAt(i)) {
					if(str1.charAt(i) == '8') count++;
					else continue;
				} else break;
			}
		}
		
		System.out.println(count);
	}
}
