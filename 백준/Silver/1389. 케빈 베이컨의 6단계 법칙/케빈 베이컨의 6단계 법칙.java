import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] network;
	static boolean[] visited;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		network = new ArrayList[N+1];
		answer = new int[N+1];
		for(int i=0; i<N+1; i++) {
			network[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			network[start].add(end);
			network[end].add(start);
		}
		
		for(int i=1; i<N+1; i++) {
			bfs(i);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<N+1; i++) {
			min = Math.min(min, answer[i]);
		}
		
		for(int i=1; i<N+1; i++) {
			if(min == answer[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void bfs(int num) {
		visited = new boolean[N+1];
		int[] distance = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visited[num] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int i : network[node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
					distance[i] += distance[node] + 1;
				}
			}
		}
		
		for(int i=1; i<N+1; i++) {
			if(i == num) continue;
			answer[num] += distance[i];
		}
	}
}