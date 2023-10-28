import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		TreeMap<String, Integer> map = new TreeMap<>();
		for(int i=0; i<N; i++) {
			String title = br.readLine();
			map.put(title, map.getOrDefault(title, 0) + 1);
			max = Math.max(max, map.get(title));
		}
		
		for(String title : map.keySet()) {
			if(map.get(title) == max) {
				System.out.println(title);
				break;
			}
		}
	}
}