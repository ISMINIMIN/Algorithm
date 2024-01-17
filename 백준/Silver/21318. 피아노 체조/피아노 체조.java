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
		
		int[] musics = new int[N+1];
		int[] scores = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			musics[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i=1; i<N; i++) {
			if(musics[i] > musics[i+1]) count++;
			scores[i] = count;
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == y) sb.append(0 + "\n");
			else sb.append(scores[y-1] - scores[x-1] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
