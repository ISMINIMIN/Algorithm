import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, deleteNode, rootNode;
	static int result = 0;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if(parent == -1) {
				rootNode = i;
				continue;
			}
			
			list.get(parent).add(i);
		}
		
		deleteNode = Integer.parseInt(br.readLine());
		
		if(deleteNode != rootNode) dfs(rootNode);
		
		System.out.println(result);
	}

	private static void dfs(int node) {
		int count = 0;
		
		for(int i : list.get(node)) {
			if(i != deleteNode) {
				count++;
				dfs(i);
			}
		}
		
		if(count == 0) result++;
	}
}
