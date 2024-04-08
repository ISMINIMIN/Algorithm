import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int count = 0;
	static int min = Integer.MAX_VALUE;
	
	static int[] time = new int[100001];
	static int[] dir = {1, -1, 2};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
			sb.append(N - K).append("\n").append(1);
			System.out.println(sb.toString());
			return;
		}
		
		bfs();
		
		sb.append(min).append("\n").append(count);
		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		time[N] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(min < time[now]) return;
			
			for(int i=0; i<3; i++) {
				int next;
				if(i == 2) next = now * dir[i];
				else next = now + dir[i];
				
				if(!isRange(next)) continue;
				
				if(next == K) {
					min = time[now];
					count++;
				}
				
				if(time[next] == 0 || time[next] == time[now] + 1) {
					queue.add(next);
					time[next] = time[now] + 1;
				}
			}
		}
	}

	private static boolean isRange(int location) {
		return location >= 0 && location <= 100000;
	}
}
