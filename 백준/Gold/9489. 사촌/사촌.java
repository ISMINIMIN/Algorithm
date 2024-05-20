import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, kIdx, count;
	static int[][] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			if(N == 0 && K == 0) break;
			
			nodes = new int[N][2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nodes[i][0] = Integer.parseInt(st.nextToken());
				if(nodes[i][0] == K) kIdx = i;
			}
			
			nodes[0][1] = -1; // root
			
			int parentIdx = 0;
			for(int i=1; i<N; i++) {
				nodes[i][1] = parentIdx;
				
				if(i < N-1 && nodes[i+1][0] - nodes[i][0] != 1) {
					parentIdx++;
				}
			}
			
			count = 0;
			if(kIdx != 0) findSiblings();
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void findSiblings() {
		int parentIdx = nodes[kIdx][1];
		int parentParentIdx = nodes[parentIdx][1];
		
		for(int i=1; i<N; i++) {
			if(nodes[i][1] >= kIdx) break;
			
			if(nodes[nodes[i][1]][1] == parentParentIdx && nodes[i][1] != parentIdx) count++;
		}
	}
}
