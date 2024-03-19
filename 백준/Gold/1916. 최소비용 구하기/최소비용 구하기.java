import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시 개수
		M = Integer.parseInt(br.readLine()); // 버스 개수
		
		distance = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken()); // 출발 도시번호
		int endCity = Integer.parseInt(st.nextToken());   // 도착 도시번호
		
		dijkstra(startCity);
		
		System.out.println(distance[endCity]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int current = node.vertex;
			
			if(visited[current]) continue;
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
