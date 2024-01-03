import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N, M;
	static int[][] ground;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		ground = new int[N][M];
		int high = 0;
		int low = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				ground[i][j] = temp;
				high = Math.max(high, temp);
				low = Math.min(low, temp);
			}
		}
		
		Map<Integer, Integer> map = new TreeMap<>();
		for(int i=low; i<=high; i++) {
			map.put(flatten(i, 0, B), i);
		}
		
		for(int key : map.keySet()) {
			if(key < 0) continue;
			else {
				System.out.println(key + " " + map.get(key));
				break;
			}
		}
	}

	private static int flatten(int height, int time, int inventory) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ground[i][j] == height) continue;
				else if(ground[i][j] > height) {
					int temp = ground[i][j] - height;
					inventory += temp;
					time += temp * 2;
				} else {
					int temp = height - ground[i][j];
					inventory -= temp;
					time += temp;
				}
			}
		}
		
		return inventory < 0 ? -1 : time;
	}
}
