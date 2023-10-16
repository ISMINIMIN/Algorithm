import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class Node implements Comparable<Node> {
		int abs;
		int val;
		
		public Node(int abs, int val) {
			this.abs = abs;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			if(o.abs == this.abs) return this.val - o.val;
			return this.abs - o.abs;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(queue.isEmpty()) sb.append(0 + "\n");
				else sb.append(queue.poll().val + "\n");
			} else queue.add(new Node(Math.abs(num), num));
		}
		
		System.out.println(sb.toString());
	}
}