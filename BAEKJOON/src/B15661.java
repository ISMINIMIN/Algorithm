import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15661 {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] S;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N]; 
		
		S = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(min);
	}

	private static void dfs(int depth) {
		if(depth == N) {
			min = Math.min(min, checkMin());
			return;
		}
		
		visited[depth] = true;
		dfs(depth+1);
		
		visited[depth] = false;
		dfs(depth+1);
	}

	private static int checkMin() {
		int teamA = 0;
		int teamB = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N; j++) {
				if(visited[i] && visited[j]) {
					teamA += (S[i][j] + S[j][i]);
				} else if(!visited[i] && !visited[j]) {
					teamB += (S[i][j] + S[j][i]);
				}
			}
		}
		
		return Math.max(teamA, teamB) - Math.min(teamA, teamB);
	}
}