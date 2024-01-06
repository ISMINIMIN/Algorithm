import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int startNode, endNode, result;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		result = 0;
		dfs(startNode, 0);
		
		if(result == 0) System.out.println(-1);
		else System.out.println(result);
	}

	private static void dfs(int node, int count) {
		if(node == endNode) {
			result = count;
			return;
		}
		
		visited[node] = true;
		
		for(int nextNode : list[node]) {
			if(!visited[nextNode]) {
				dfs(nextNode, count+1);
			}
		}
		
		visited[node] = false;
	}
}
