import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int location;
		int time;
		
		public Node(int location, int time) {
			this.location = location;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		bfs(N, M);
	}

	private static void bfs(int start, int end) {
		int[] caze = new int[3];
		boolean[] visited = new boolean[100001];
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.location == end) {
				System.out.println(current.time);
			}
			
			caze[0] = current.location * 2;
			caze[1] = current.location - 1;
			caze[2] = current.location + 1;
			
			for(int i=0; i<3; i++) {
				if(isRange(caze[i]) && !visited[caze[i]]) {
					if(i == 0) queue.add(new Node(caze[i], current.time));
					else queue.add(new Node(caze[i], current.time + 1));
					visited[caze[i]]= true;
				}
			}
		}
	}

	private static boolean isRange(int location) {
		if(location >= 0 && location <= 100000) return true;
		return false;
	}
}
