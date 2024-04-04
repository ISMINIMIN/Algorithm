import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("Case #").append(t).append(":");
			String[] temp = br.readLine().split(" ");
			
			for(int i=temp.length-1; i>=0; i--) {
				sb.append(" ").append(temp[i]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
