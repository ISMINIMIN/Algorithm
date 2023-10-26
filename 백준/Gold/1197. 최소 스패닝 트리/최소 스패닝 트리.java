import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] arr;
	
	static class Edge implements Comparable<Edge> {
		int startNode;
		int endNode;
		int value;
		
		public Edge(int startNode, int endNode, int value) {
			super();
			this.startNode = startNode;
			this.endNode = endNode;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		arr = new int[V+1];
		for(int i=1; i<V+1; i++) {
			arr[i] = i;
		}
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		for(int i=0; i<E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			queue.add(new Edge(s, e, v));
		}
		
		int count = 1;
		int valueSum = 0;
		
		while(count < V) {
			Edge currentEdge = queue.poll();
			if(find(currentEdge.startNode) != find(currentEdge.endNode)) {
				union(currentEdge.startNode, currentEdge.endNode);
				count++;
				valueSum += currentEdge.value;
			}
		}
		
		System.out.println(valueSum);
	}

	private static int find(int a) {
		if(a == arr[a]) return a;
		else return arr[a] = find(arr[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			arr[b] = a;
		}
	}
}