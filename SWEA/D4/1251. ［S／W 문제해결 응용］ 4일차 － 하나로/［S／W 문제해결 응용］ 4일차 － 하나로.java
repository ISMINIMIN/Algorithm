import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[] root;
	static PriorityQueue<Edge> queue;
	
	static class Edge implements Comparable<Edge> {
		int node1;
		int node2;
		long value;
		
		public Edge(int node1, int node2, long value) {
			super();
			this.node1 = node1;
			this.node2 = node2;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.value, o.value);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[2][N+1];
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<N+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());		
				}
			}
			
			double E = Double.parseDouble(br.readLine());
			
			queue = new PriorityQueue<>();
			for(int i=1; i<N; i++) {
				for(int j=i+1; j<N+1; j++) {
					queue.add(new Edge(i, j, getValue(i, j)));
				}
			}
			
			root = new int[N+1];
			for(int i=1; i<N+1; i++) {
				root[i] = i;
			}
			
			int count = 1;
			double result = 0;
			
			while(count < N) {
				Edge edge = queue.poll();
				if(find(edge.node1) != find(edge.node2)) {
					union(edge.node1, edge.node2);
					result += edge.value;
					count++;
				}
			}
			
			System.out.println("#" + t + " " + Math.round(result*E));
		}
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

	private static long getValue(int i, int j) {
		int a = Math.abs(arr[0][i] - arr[0][j]);
		int b = Math.abs(arr[1][i] - arr[1][j]);
		return (long)(Math.pow(a, 2) + Math.pow(b, 2));
	}
}