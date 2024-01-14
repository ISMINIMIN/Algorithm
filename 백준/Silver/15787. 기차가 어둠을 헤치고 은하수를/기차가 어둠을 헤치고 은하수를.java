import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int[] trains;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		trains = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			int train = Integer.parseInt(st.nextToken());
			
			if(type == 1) {
				int seat = Integer.parseInt(st.nextToken());
				trains[train] |= (1 << seat);
			} else if(type == 2) {
				int seat = Integer.parseInt(st.nextToken());
				trains[train] &= ~(1 << seat);
			} else if(type == 3) {
				trains[train] <<= 1;
	            trains[train] &= ((1 << 21) - 1);
			} else if(type == 4) {
				trains[train] >>= 1;
	            trains[train] &= ~1;
			}
		}
		
		HashSet<Integer> result = new HashSet<>();
		for(int i=1; i<N+1; i++) {
			result.add(trains[i]);
		}
		
		System.out.println(result.size());
	}
}
