import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			queue.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<M; i++) {
			long first = queue.poll();
			long second = queue.poll();
			
			queue.add(first + second);
			queue.add(first + second);
		}
		
		long sum = 0;
		while(!queue.isEmpty()) {
			sum += queue.poll();
		}
		
		System.out.println(sum);
	}
}