import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				String operation = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(operation.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if(map.isEmpty()) continue;
					
					int key = 0;
					if(num == 1) key = map.lastKey();
					else key = map.firstKey();
					int value = map.get(key);
					
					if(value == 1) map.remove(key);
					else map.put(key, value - 1);
				}
			}
			
			if(map.isEmpty()) System.out.println("EMPTY");
			else System.out.println(map.lastKey() + " " + map.firstKey());
		}
	}
}