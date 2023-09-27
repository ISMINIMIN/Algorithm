import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int count = 0;
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
 
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if (arr[i][0] < arr[j][0] && arr[i][1] > arr[j][1]) {
                    	count++;
                    } else if(arr[i][0] > arr[j][0] && arr[i][1] < arr[j][1]){
                    	count++;
                    }
                }
            }
 
            System.out.println("#" + t + " " + count);
		}
    }
}