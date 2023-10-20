import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] nums = new String[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = br.readLine();
		}
		
		int result = 0;
		for(int i=nums[0].length()-1; i>=0; i--) {
			HashSet<String> set = new HashSet<>();
			for(int j=0; j<N; j++) {
				set.add(nums[j].substring(i, nums[j].length()));
			}
			
			result++;
			if(set.size() == N) break;
		}
		
		System.out.println(result);
	}
}