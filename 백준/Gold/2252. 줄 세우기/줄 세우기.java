import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] priority;
	
	static List<ArrayList<Integer>> list;
	static PriorityQueue<Integer> queue;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		priority = new int[N+1];
		list = new ArrayList<>();
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list.get(prev).add(next);
			priority[next]++;
		}
		
		lineUp();
		
		System.out.println(sb.toString());
	}

	private static void lineUp() {
		queue = new PriorityQueue<>();
		
		for(int i=1; i<N+1; i++) {
			if(priority[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int next : list.get(now)) {
				priority[next]--;
				if(priority[next] == 0) {
					queue.add(next);
				}
			}
		}
	}
}
