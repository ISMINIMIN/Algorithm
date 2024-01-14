import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Boolean>> trains = new ArrayList<>();
		HashSet<ArrayList<Boolean>> result = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			trains.add(new ArrayList<>());
			for(int j=0; j<20; j++) {
				trains.get(i).add(false);
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int train = Integer.parseInt(st.nextToken()) - 1;
			
			if(type == 1 || type == 2) {
				int seat = Integer.parseInt(st.nextToken()) - 1;
				if(type == 1) trains.get(train).set(seat, true);
				else trains.get(train).set(seat, false);
			} else if(type == 3) {
				trains.get(train).add(0, false);
				trains.get(train).remove(20);
			} else if(type == 4) {
				trains.get(train).add(false);
				trains.get(train).remove(0);
			}
		}
		
		for(ArrayList train : trains) {
			result.add(train);
		}
		
		System.out.println(result.size());
	}
}
