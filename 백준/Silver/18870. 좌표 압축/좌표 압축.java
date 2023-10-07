import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] origin = new int[N];
		int[] sort = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			origin[i] = sort[i] =  num;
	
		}
		
		Arrays.sort(sort);
		
		int index = 0;
		
		for(int i=0; i<N; i++) {
			if(!map.containsKey(sort[i])) {
				map.put(sort[i], index);
				index++;
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(origin[i]) + " ");
		}
		
		System.out.println(sb.toString());
	}
}