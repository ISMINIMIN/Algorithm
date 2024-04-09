import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int[] bottles;
	static boolean[][] visited;
	static Set<Integer> results = new TreeSet<>();
	
	final static int LEN = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		bottles = new int[LEN];
		
		for(int i=0; i<LEN; i++) {
			bottles[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[bottles[0] + 1][bottles[1] + 1];
		
		dfs(0, 0, bottles[2]);
		
		for(int result : results) {
			sb.append(result).append(" ");
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int A, int B, int C) {
		if(visited[A][B]) return;
		
		visited[A][B] = true;
		
		if(A == 0) results.add(C);
		
		// A 물통에서 B 물통으로
		if(A + B > bottles[1]) dfs(A + B - bottles[1], bottles[1], C);
		else dfs(0, A + B, C);
		
		// A 물통에서 C 물통으로
		if(A + C > bottles[2]) dfs(A + C - bottles[2], B, bottles[2]);
		else dfs(0, B, A + C);
		
		// B 물통에서 A 물통으로
		if(A + B > bottles[0]) dfs(bottles[0], A + B - bottles[0], C);
		else dfs(A + B, 0, C);
		
		// B 물통에서 C 물통으로
		if(B + C > bottles[2]) dfs(A, B + C - bottles[2], bottles[2]);
		else dfs(A, 0, B + C);
		
		// C 물통에서 A 물통으로
		if(A + C > bottles[0]) dfs(bottles[0], B, A + C - bottles[0]);
		else dfs(A + C, B, 0);
		
		// C 물통에서 B 물통으로
		if(B + C > bottles[1]) dfs(A, bottles[1], B + C - bottles[1]);
		else dfs(A, B + C, 0);
	}
}
