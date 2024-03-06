import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i;
		}
		
		int result = 0;
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(union(a, b)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return true;
		
		arr[b] = a;
		return false;
	}

	private static int find(int a) {
		if(a == arr[a]) return a;
		return arr[a] = find(arr[a]);
	}
}
