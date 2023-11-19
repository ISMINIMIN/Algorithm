import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static int N, M;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			dfs(i, 1); // 시작하는 노드도 친구에 포함되므로 1명(depth)으로 시작
			if(flag) break; // 이미 친구 관계를 찾았으므로 종료
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	private static void dfs(int node, int depth) {
		if(depth == 5) { // 연결된 친구가 5명 이상인 경우 ABCDE 친구 관계
			flag = true;
			return;
		}
		
		visited[node] = true;
		for(int i : list[node]) {
			if(!visited[i]) {
				dfs(i, depth+1);
			}
		}
		
		visited[node]= false;
	}
}