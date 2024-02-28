import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
			max = Math.max(max, num);
		}
		
		int[] cnt = new int[max+1];
		for(int i=0; i<N; i++) {
			cnt[nums[i]]++;
		}
		
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			int temp = nums[i];
			for(int j=1; j*j<=temp; j++) {
				if(temp % j == 0) {
					if(temp / j != j) answer[i] += cnt[temp/j];
					answer[i] += cnt[j];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(answer[i]-1).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
