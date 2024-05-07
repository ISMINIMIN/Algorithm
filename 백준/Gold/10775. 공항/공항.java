import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int G, P;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		parent = new int[G+1];
		
		for(int i=1; i<G+1; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		for(int i=0; i<P; i++) {
			int g = Integer.parseInt(br.readLine());
			int assignedGate = find(g);
			
			if(assignedGate == 0) break;
			
			result++;
			union(assignedGate, assignedGate-1);
		}
		
		System.out.println(result);
	}

	private static void union(int a, int b) {
		a = parent[a];
		b = parent[b];
		
		if(a != b) parent[a] = b;
	}

	private static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
}
