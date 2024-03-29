import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			queue.add(new Edge(start, end, cost));
		}
		
		System.out.println(kruskal());
	}

	private static int kruskal() {
		int sum = 0;
		int maxCost = 0;
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				sum += edge.cost;
				maxCost = Math.max(maxCost, edge.cost);
			}
		}
		
		return sum - maxCost;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	private static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
}
