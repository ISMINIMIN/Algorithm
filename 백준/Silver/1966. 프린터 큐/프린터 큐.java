import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx;
		int pri;
		
		public Node(int idx, int pri) {
			this.idx = idx;
			this.pri = pri;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			Queue<Node> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = new ArrayList<>();
			int cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int pri = Integer.parseInt(st.nextToken());
				queue.add(new Node(i, pri));
				list.add(pri);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			while(true) {
				Node node = queue.poll();
				
				if(node.pri == list.get(cnt)) {
					cnt++;
					if(node.idx == target) break;
				} else {
					queue.add(node);
				}
			}
			
			System.out.println(cnt);
		}
	}
}