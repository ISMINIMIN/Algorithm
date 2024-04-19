import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int V, dist;
	static int result = 0;
	static int maxNode;
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	
	static class Node {
		int node;
		int dist;
		
		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i=0; i<V+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				if(end == -1) break;
				
				int dist = Integer.parseInt(st.nextToken());
				list.get(start).add(new Node(end, dist));
			}
		}
		
		visited = new boolean[V+1];
		visited[1] = true;
		dfs(1, 0);
		
		visited = new boolean[V+1];
		visited[maxNode] = true;
		dfs(maxNode, 0);
		
		System.out.println(result);
	}

	private static void dfs(int node, int sum) {
		if(result < sum) {
			result = sum;
			maxNode = node;
		}
		
		for(Node next : list.get(node)) {
			if(!visited[next.node]) {
				visited[next.node] = true;
				dfs(next.node, sum + next.dist);
			}
		}
	}
}
