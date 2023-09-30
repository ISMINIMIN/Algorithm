import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] root;
	
	static class Edge implements Comparable<Edge> {
		int com1;
		int com2;
		int len;
		
		public Edge(int com1, int com2, int len) {
			super();
			this.com1 = com1;
			this.com2 = com2;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return this.len - o.len;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		root = new int[N+1];
		for(int i=1; i<N+1; i++) {
			root[i] = i;
		}
		
		int maxLen = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		for(int i=1; i<N+1; i++) {
			String line = sc.next();
			for(int j=1; j<N+1; j++) {
				int len = changeNum(line.charAt(j-1));
				maxLen += len;
				if(len != 0 && i != j) {
					queue.add(new Edge(i, j, len));
				}
			}
		}
		
		int edgeCount = 1;
		int minLen = 0;
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(find(edge.com1) != find(edge.com2)) {
				union(edge.com1, edge.com2);
				minLen += edge.len;
				edgeCount++;
			}
		}
		
		if(edgeCount == N) System.out.println(maxLen - minLen);
		else System.out.println(-1);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) root[b] = a;
	}

	private static int find(int a) {
		if(a == root[a]) return a;
		else return root[a] = find(root[a]);
	}

	private static int changeNum(char letter) {
		if(letter >= 'a' && letter <= 'z') return letter - 'a' + 1;
		else if(letter >= 'A' && letter <= 'Z') return letter - 'A' + 27;
		else return 0;
	}
}