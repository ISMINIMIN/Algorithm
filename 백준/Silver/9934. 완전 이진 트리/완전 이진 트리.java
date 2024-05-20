import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int[] buildings;
	static List<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		K = Integer.parseInt(br.readLine());
		
		buildings = new int[(int)Math.pow(2, K) - 1];
		list = new ArrayList<>();
		
		for(int i=0; i<K; i++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<buildings.length; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		
		search(0, 0, buildings.length - 1);
		
		for(ArrayList<Integer> tempList : list) {
			for(int building : tempList) {
				sb.append(building).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void search(int depth, int start, int end) {
		if(depth == K) {
			return;
		}
		
		int mid = (start + end) / 2;
		list.get(depth).add(buildings[mid]);
		
		search(depth + 1, start, mid - 1);
		search(depth + 1, mid + 1, end);
	}
}
