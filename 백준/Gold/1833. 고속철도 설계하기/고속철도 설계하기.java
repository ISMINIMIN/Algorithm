import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int sum = 0;
	static int[] parent;
	static List<Edge> existRoad = new ArrayList<>();
	static List<Edge> newRoad = new ArrayList<>();
	static List<Edge> pickRoad = new ArrayList<>();
	
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
					existRoad.add(new Edge(start, end, cost * -1));
					continue;
				}
				
				newRoad.add(new Edge(start, end, cost));
			}
		}
		
		Collections.sort(existRoad);
		Collections.sort(newRoad);
		
		kruskal();
		sb.append(sum).append(" ").append(pickRoad.size()).append("\n");
		
		for(Edge edge : pickRoad) {
			sb.append(edge.start).append(" ").append(edge.end).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void kruskal() {
		for(int i=0; i<existRoad.size(); i++) {
			Edge edge = existRoad.get(i);
			union(edge.start, edge.end);
			sum += edge.cost;
		}
		
		for(int i=0; i<newRoad.size(); i++) {
			Edge edge = newRoad.get(i);
			
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				pickRoad.add(edge);
				sum += edge.cost;
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
