import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	static ArrayList<Node>[] list;
	static ArrayList<Node>[] list_reverse;
	
	static class Node implements Comparable<Node>{
		int vertex;
		int time;
		
		public Node(int vertex, int time) {
			this.vertex = vertex;
			this.time = time;
		}

		@Override
		public int compareTo(Node n) {
			return this.time - n.time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 도로 개수
		X = Integer.parseInt(st.nextToken()); // 파티 장소
		
		list = new ArrayList[N+1];
		list_reverse = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
			list_reverse[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, time));
			list_reverse[end].add(new Node(start, time));
		}
		
		int[] xToStart = dijkstra(list);
		int[] startToX = dijkstra(list_reverse);
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			max = Math.max(max, xToStart[i] + startToX[i]);
		}
		
		System.out.println(max);
	}
	
	private static int[] dijkstra(ArrayList<Node>[] list) {
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(X, 0));
		distance[X] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int current = node.vertex;
			
			if(visited[current]) continue;
			visited[current] = true;
			
			for(Node next : list[current]) {
				if(distance[next.vertex] > distance[current] + next.time) {
					distance[next.vertex] = distance[current] + next.time;
					queue.add(new Node(next.vertex, distance[next.vertex]));
				}
			}
		}
		
		return distance;
	}
}
