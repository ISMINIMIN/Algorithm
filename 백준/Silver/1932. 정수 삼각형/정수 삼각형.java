import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] list = new ArrayList[N];
		List<Integer>[] DP = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
			DP[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		DP[0].add(list[0].get(0));
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0) DP[i].add(DP[i-1].get(j) + list[i].get(j));
				else if(j == i) DP[i].add(DP[i-1].get(j-1) + list[i].get(j));
				else DP[i].add(Math.max(DP[i-1].get(j-1), DP[i-1].get(j)) + list[i].get(j));
			}
		}
		
		int max = 0;
		for(int num : DP[N-1]) {
			max = Math.max(max, num);
		}
		
		System.out.println(max);
	}
}
