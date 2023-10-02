import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, E;
	static ArrayList<Integer> list[];
	static boolean visited[];
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			list[com1].add(com2);
			list[com2].add(com1);
		}
		
		visited = new boolean[N+1];
		bfs(1);
		
		System.out.println(count);
	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int currentNode = queue.poll();
			
			for(int i : list[currentNode]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}