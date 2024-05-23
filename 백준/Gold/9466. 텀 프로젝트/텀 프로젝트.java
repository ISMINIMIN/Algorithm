import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, selected;
	static int[] students;
	static boolean[] visited, checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			selected = 0;
			
			students = new int[N+1];
			visited = new boolean[N+1];
			checked = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<N+1; i++) {
				if(checked[i]) continue;
				dfs(i);
			}
			
			sb.append(N - selected).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int now) {
		if(checked[now]) return;
		
		if(visited[now]) {
			checked[now] = true;
			selected++;
		}
		
		visited[now] = true;
		dfs(students[now]);
		checked[now] = true;
		visited[now] = false;
	}
}
