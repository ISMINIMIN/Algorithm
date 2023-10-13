import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String kind = st.nextToken();
				
				map.put(kind, map.getOrDefault(kind, 0) + 1);
			}
			
			int answer = 1;
			for(String kind : map.keySet()) {
				answer *= map.get(kind) + 1;
			}
			
			System.out.println(answer - 1);
		}
	}
}