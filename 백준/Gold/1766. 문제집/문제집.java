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
	
	static List<Integer>[] list;
	static PriorityQueue<Integer> queue;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		priority = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			list[prev].add(next);
			priority[next]++;
		}
		
		System.out.println(checkList());
	}

	private static String checkList() {
		queue = new PriorityQueue<>();
		sb = new StringBuilder();
		
		for(int i=1; i<N+1; i++) {
			add(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int next : list[now]) {
				priority[next]--;
				add(next);
			}
		}
		
		return sb.toString();
	}

	private static void add(int problem) {
		if(priority[problem] == 0) {
			queue.add(problem);
		}
	}
}
