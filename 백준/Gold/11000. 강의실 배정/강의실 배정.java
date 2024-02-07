import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int start;
		int end;
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
	    public int compareTo(Node o) {
	        if (this.start != o.start) {
	            return this.start - o.start;
	        } else {
	            return this.end - o.end;
	        }
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		ArrayList<Node> list = new ArrayList<Main.Node>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end));
		}
		
		Collections.sort(list);
		
		int time = 0;
		for(Node node : list) {
			time = node.end;
			if(!queue.isEmpty() && queue.peek() <= node.start) queue.poll();
			queue.add(time);
		}
		
		System.out.println(queue.size());
	}
}
