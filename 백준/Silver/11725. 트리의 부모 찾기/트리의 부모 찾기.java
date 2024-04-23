import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		result = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		dfs(1);
		
		for(int i=2; i<N+1; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int node) {
		visited[node] = true;
		
		for(int next : list.get(node)) {
			if(!visited[next]) {
				result[next] = node;
				dfs(next);
			}
		}
	}
}
