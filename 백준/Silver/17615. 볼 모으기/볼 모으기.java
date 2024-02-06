import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static String balls;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		balls = br.readLine();
		
		left('R', 'B');
		left('B', 'R');
		right('R', 'B');
		right('B', 'R');
		
		System.out.println(min);
	}

	private static void left(char target, char other) {
		int cnt = 0;
		boolean chk = false;
		
		for(int i=0; i<N; i++) {
			char tmp = balls.charAt(i);
			if(chk && tmp == target) {
				cnt++;
				continue;
			}
			
			if(tmp == other) chk = true;
		}
		
		min = Math.min(min, cnt);
	}
	
	private static void right(char target, char other) {
		int cnt = 0;
		boolean chk = false;
		
		for(int i=N-1; i>=0; i--) {
			char tmp = balls.charAt(i);
			if(chk && tmp == target) {
				cnt++;
				continue;
			}
			
			if(tmp == other) chk = true;
		}
		
		min = Math.min(min, cnt);
	}
}
