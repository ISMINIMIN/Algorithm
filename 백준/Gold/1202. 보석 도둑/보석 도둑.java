import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Jewel implements Comparable<Jewel> {
		int weight;
		int cost;
		
		public Jewel(int weight, int cost) {
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public int compareTo(Jewel j) {
			if(this.weight == j.weight) return j.cost - this.cost;
			return this.weight - j.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Jewel> jewels = new ArrayList<>();
		List<Integer> bags = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(M,  V));
		}
		
		for(int i=0; i<K; i++) {
			int C = Integer.parseInt(br.readLine());
			bags.add(C);
		}
		
		Collections.sort(jewels);
		Collections.sort(bags);
		
		int idx = 0;
		long result = 0;
		for(int bag : bags) {
			while(idx < jewels.size() && jewels.get(idx).weight <= bag) {
				queue.add(jewels.get(idx).cost);
				idx++;
			}
			
			if(!queue.isEmpty())result += queue.poll();
		}
		
		System.out.println(result);
	}
}
