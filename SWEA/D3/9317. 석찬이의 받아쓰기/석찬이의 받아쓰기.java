import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
    	
    	for(int t=1; t<=T; t++) {
    		int N = Integer.parseInt(br.readLine());
    		String ans = br.readLine();
    		String sub = br.readLine();
    		int count = 0;
    		
    		for(int i=0; i<N; i++) {
    			if(ans.charAt(i) == sub.charAt(i)) count++;
    		}
    		
    		System.out.println("#" + t + " " + count);
    	}
    }
}