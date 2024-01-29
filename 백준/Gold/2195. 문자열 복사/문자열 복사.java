import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String P = br.readLine();
		
		int idx = 0;
		int count = 1;
		
		for(int i=0; i<P.length(); i++) {
			if(S.indexOf(P.substring(idx, i+1)) != -1) continue;
			idx = i;
			count++;
		}
		
		System.out.println(count);
	}
}
