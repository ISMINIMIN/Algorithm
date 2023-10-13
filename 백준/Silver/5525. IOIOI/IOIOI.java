import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		int count = 0;
		int answer = 0;
		
		for(int i=1; i<M-1;) {
			if(line.charAt(i) == 'O' && line.charAt(i+1) == 'I') {
				count++;
				
				if(count == N) {
					if(line.charAt(i-(count*2-1)) == 'I') answer++;
					count--;
				}
				
				i += 2;
			} else {
				count = 0;
				i++;
			}
		}
		
		System.out.println(answer);
	}
}