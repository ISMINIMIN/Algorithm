import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		
		int[][][] DP = new int[str1.length()+1][str2.length()+1][str3.length()+1];
		
		for(int i=1; i<=str1.length(); i++) {
			char c1 = str1.charAt(i-1);
			for(int j=1; j<=str2.length(); j++) {
				char c2 = str2.charAt(j-1);
				for(int k=1; k<=str3.length(); k++) {
					char c3 = str3.charAt(k-1);
					
					if(c1 == c2 && c2 == c3) DP[i][j][k] = DP[i-1][j-1][k-1] + 1;
					else DP[i][j][k] = Math.max(DP[i-1][j][k], Math.max(DP[i][j-1][k], DP[i][j][k-1]));
				}
			}
		}
		
		System.out.println(DP[str1.length()][str2.length()][str3.length()]);
	}
}
