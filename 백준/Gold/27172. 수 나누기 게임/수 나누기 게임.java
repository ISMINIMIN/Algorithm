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
		int max = 0;
		
		int[] cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int card = Integer.parseInt(st.nextToken());
			cards[i] = card;
			max = Math.max(max, card);
		}
		
		int[] results = new int[max+1];
		boolean[] check = new boolean[max+1];
		
		for(int i: cards) {
			check[i] = true;
		}
		
		for(int i : cards) {
			for(int j=i*2; j<max+1; j+=i) {
				if(check[j]) {
					results[i]++;
					results[j]--;
				}
			}
		}
		
		for(int i : cards) {
			sb.append(results[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
}
