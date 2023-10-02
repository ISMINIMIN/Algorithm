import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int S = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String operation = st.nextToken();
			if(operation.equals("all")) S = (1 << 21) - 1;
			else if(operation.equals("empty")) S = 0;
			else {
				int element = Integer.parseInt(st.nextToken());
				if(operation.equals("add")) S |= (1 << element);
				else  if(operation.equals("remove")) S &= ~(1 << element);
				else if(operation.equals("check")) {
					if((S & (1 << element)) == 0) sb.append(0 + "\n");
					else sb.append(1 + "\n");
				} else if(operation.equals("toggle")) {
					if((S & (1 << element)) == 0) S |= (1 << element);
					else S &= ~(1 << element);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}