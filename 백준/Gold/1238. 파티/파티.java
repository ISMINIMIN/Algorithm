import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	static int[][] distance;
	static ArrayList<Node>[] list;
	
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
		
		distance = new int[N+1][N+1];
		list = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
			for(int j=1; j<N+1; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, time));
		}
		
		for(int i=1; i<N+1; i++) {
			dijkstra(i);
		}
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			max = Math.max(max, distance[i][X] + distance[X][i]);
		}
		
		System.out.println(max);
	}
	
	private static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		distance[start][start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int current = node.vertex;
			
			if(visited[current]) continue;
			visited[current] = true;
			
			for(Node next : list[current]) {
				if(distance[start][next.vertex] > distance[start][current] + next.time) {
					distance[start][next.vertex] = distance[start][current] + next.time;
					queue.add(new Node(next.vertex, distance[start][next.vertex]));
				}
			}
		}
	}
}
