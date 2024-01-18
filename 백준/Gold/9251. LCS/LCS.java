import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		char[] arr1 = new char[str1.length()];
		char[] arr2 = new char[str2.length()];
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = str1.charAt(i);
		}
		
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = str2.charAt(i);
		}
		
		int[][] DP = new int[arr1.length+1][arr2.length+1];
		
		for(int i=1; i<=arr1.length; i++) {
			for(int j=1; j<=arr2.length; j++) {
				if(arr1[i-1] == arr2[j-1]) DP[i][j] = DP[i-1][j-1] + 1;
				else DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
			}
		}
		
		System.out.println(DP[arr1.length][arr2.length]);
	}
}
