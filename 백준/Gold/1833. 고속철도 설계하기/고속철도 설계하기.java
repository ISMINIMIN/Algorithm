import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int sum = 0;
	static int cnt = 0;
	static int[] parent;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static List<Edge> list = new ArrayList<>();
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;
		int status; // 1 - new
		
		public Edge(int start, int end, int cost, int status) {
			this.start = start;
			this.end = end;
			this.cost = cost;
			this.status = status;
		}

		@Override
		public int compareTo(Edge e) {
			return this.status == e.status ? this.cost - e.cost : this.status - e.status;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N+1][N+1];
		parent = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int end=1; end<N+1; end++) {
			for(int start=1; start<end; start++) {
				int cost = info[end][start];
				if(cost < 0) {
					sum += Math.abs(cost);
					queue.add(new Edge(start, end, Math.abs(cost), 0));
					continue;
				}
				
				queue.add(new Edge(start, end, Math.abs(cost), 1));
			}
		}
		
		kruskal();
		sb.append(sum).append(" ").append(cnt).append("\n");
		
		for(Edge edge : list) {
			sb.append(edge.start).append(" ").append(edge.end).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void kruskal() {
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				if(edge.status == 1) {
					list.add(edge);
					sum += edge.cost;
					cnt++;
				}
			}
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) parent[b] = a;
	}

	private static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
}
