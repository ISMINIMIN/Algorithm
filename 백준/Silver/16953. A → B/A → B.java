import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int count = 1;
		
		while(Long.parseLong(B) > Long.parseLong(A)) {
			if(B.charAt(B.length()-1) == '1') {
				B = B.substring(0, B.length()-1);
			} else  if(Long.parseLong(B) % 2 == 0) {
				B = Long.toString(Long.parseLong(B) / 2);
			} else break;
			
			count++;
		}
		
		if(A.equals(B)) System.out.println(count);
		else System.out.println(-1);
	}
}