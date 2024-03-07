import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] arr, candies, counts;
	static int[][] dp;
	static ArrayList<Node> list;
	
	static class Node {
		int candy;
		int count;
		
		public Node(int candy, int count) {
			this.candy = candy;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		candies = new int[N+1];
		counts = new int[N+1];
		Arrays.fill(counts, 1);
		
		list = new ArrayList<>();
		
		for(int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			candies[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		check();
		dp();
		
		System.out.println(dp[list.size()][K-1]);
	}

	private static void dp() {
		dp = new int[list.size()+1][K];
		
		for(int i=1; i<list.size()+1; i++) {
			int candy = list.get(i-1).candy;
			int count = list.get(i-1).count;
			
			for(int j=0; j<K; j++) {
				if(count <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-count] + candy);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
	}

	private static void check() {
		for(int i=1; i<N+1; i++) {
			if(arr[i] != i) {
				int temp = find(i);
				candies[temp] += candies[i];
				counts[temp]++;
			}
		}
		
		for(int i=1; i<N+1; i++) {
			if(arr[i] == i) {
				list.add(new Node(candies[i], counts[i]));
			}
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b) arr[b] = a;
		else arr[a] = b;
	}

	private static int find(int a) {
		if(a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}
}
