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
			int cnt = Integer.parseInt(st.nextToken());
			
			int prev = Integer.parseInt(st.nextToken());
			for(int j=1; j<cnt; j++) {
				int next = Integer.parseInt(st.nextToken());
				list.get(prev).add(next);
				priority[next]++;
				
				prev = next;
			}
		}
		
		System.out.println(lineUp());
	}

	private static String lineUp() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		List<Integer> singers = new ArrayList<>();
		
		for(int i=1; i<N+1; i++) {
			if(priority[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			singers.add(now);
			
			for(int next : list.get(now)) {
				priority[next]--;
				
				if(priority[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		if(singers.size() != N) return "0";
		
		for(int singer : singers) {
			sb.append(singer).append("\n");
		}
		
		return sb.toString();
	}
}
