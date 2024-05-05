import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, W;
	static int[] times, priority, dp;
	static List<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			times = new int[N+1];
			priority = new int[N+1];
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N+1; i++) {
				list.add(new ArrayList<>());
				
				if(i == 0) continue;
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int prev = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				list.get(prev).add(next);
				priority[next]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			build();
			sb.append(dp[W]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void build() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		dp = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			dp[i] = times[i];
			if(priority[i] == 0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int next : list.get(now)) {
				dp[next] = Math.max(dp[next], dp[now] + times[next]);
				
				priority[next]--;
				if(priority[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}
