import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		
		public Node(int vertex, int value) {
			this.vertex = vertex;
			this.weight = value;
		}

		@Override
		public int compareTo(Node n) {
			if(this.weight > n.weight) return 1;
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		
		for(int i=1; i<V+1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // start
			int v = Integer.parseInt(st.nextToken()); // end
			int w = Integer.parseInt(st.nextToken()); // weight
			list[u].add(new Node(v, w));
		}
		
		dijkstra(K);
		
		for(int i=1; i<V+1; i++) {
			if(visited[i]) sb.append(distance[i]).append("\n");
			else sb.append("INF\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int current = node.vertex;
			
			if(visited[current]) continue; // 이미 방문한 노드는 다시 큐에 넣지 않음
			visited[current] = true;
			
			for(Node next : list[current]) {
				if(distance[next.vertex] > distance[current] + next.weight) {
					distance[next.vertex] = distance[current] + next.weight;
					queue.add(new Node(next.vertex, distance[next.vertex]));
				}
			}
		}
	}
}
