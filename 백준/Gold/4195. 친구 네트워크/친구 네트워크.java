import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] root, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0; t<TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> map = new HashMap<>();
			root = new int[N*2];
			count = new int[N*2];
			
			for(int i=0; i<2*N; i++) {
				root[i] = i;
				count[i] = 1;
			}
			
			int idx = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String id1 = st.nextToken();
				String id2 = st.nextToken();
				
				if(!map.containsKey(id1)) map.put(id1, idx++);
				if(!map.containsKey(id2)) map.put(id2, idx++);
				
				int result = union(map.get(id1), map.get(id2));
				System.out.println(result);
			}
		}
	}

	private static int union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a < b) {
				root[b] = a;
				count[a] += count[b];
				return count[a];
			} else {
				root[a] = b;
				count[b] += count[a];
				return count[b];
			}
		}
		
		return count[a];
	}

	private static int find(int a) {
		if(a == root[a]) return a;
		return root[a] = find(root[a]);
	}
}