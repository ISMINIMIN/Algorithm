import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		String[] mon = new String[N+1];
		
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			map.put(name, i);
			mon[i] = name;
		}
		
		for(int i=0; i<M; i++) {
			String problem = br.readLine();
			if(isNumber(problem)) {
				System.out.println(mon[Integer.parseInt(problem)]);
			} else {
				System.out.println(map.get(problem));
			}
		}
	}

	private static boolean isNumber(String problem) {
		try {
			Integer.parseInt(problem);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}