import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static ArrayList<Integer> list[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			list = new ArrayList[N+1];
			for(int i=1; i<N+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			int result = 0;
			bfs(1);
			for(int i=2; i<N+1; i++) {
				if(visited[i]) result++;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		int count = 0;
		
		while(count != list[1].size()+1) {
			int currentNode = queue.poll();
			for(int i : list[currentNode]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
			count++;
		}
	}
}
