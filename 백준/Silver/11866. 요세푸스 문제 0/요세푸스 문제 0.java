import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		int count = 1;
		while(!queue.isEmpty()) {
			if(count % K == 0) {
				sb.append(queue.poll());
				if(queue.size() >= 1) sb.append(", ");
			} else queue.add(queue.poll());
			count++;
		}
		
		
		System.out.println("<" + sb.toString() + ">");
	}
}
