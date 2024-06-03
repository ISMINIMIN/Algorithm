import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		int[] want = new int[M];
		arr = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			want[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(map[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		boolean flag = true;
		int root = find(want[0]);
		for(int i=1; i<M; i++) {
			if(root != find(want[i])) {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) arr[b] = a;
	}

	private static int find(int a) {
		if(a == arr[a]) return a;
		else return arr[a] = find(arr[a]);
	}
}