import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11403 {
	static int N;
	static int[][] map;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			visited = new int[N];
			dfs(i);
			for(int j=0; j<N; j++) {
				System.out.print(visited[j] + " ");
			}
			System.out.println();
		}
	}

	private static void dfs(int node) {
		for(int i=0; i<N; i++) {
			if(map[node][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(i);
			}
		}
	}
}