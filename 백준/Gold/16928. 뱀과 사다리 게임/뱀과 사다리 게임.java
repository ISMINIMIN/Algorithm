import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> move[];
	static boolean[][] visited = new boolean[2][101];
	
	static class Node {
		int current;
		int count;
		
		public Node(int current, int count) {
			this.current = current;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		move = new ArrayList[101];
		
		for(int i=1; i<101; i++) {
			move[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			move[start].add(end);
		}
		
		System.out.println(bfs(1));
	}

	private static int bfs(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		visited[0][1] = true;
		
		while(true) {
			Node node = queue.poll();
			
			if(node.current == 100) {
				return node.count;
			}
			
			for(int i=1; i<=6; i++) {
				int next = node.current + i;
				
				if(next > 100) continue;
				if(visited[0][next]) continue;
				
				if(move[next].size() != 0 && !visited[1][move[next].get(0)]) {
					queue.add(new Node(move[next].get(0), node.count+1));
					visited[1][move[next].get(0)] = true;
				} else {
					queue.add(new Node(next, node.count+1));
					visited[0][next] = true;
				}
			}
		}
	}
}