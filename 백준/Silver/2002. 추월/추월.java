import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<String> queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			queue.add(br.readLine());
		}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			String car = br.readLine();
			if(queue.peek().equals(car)) queue.poll();
			else {
				queue.remove(car);
				result++;
			}
		}
		
		System.out.println(result);
	}
}