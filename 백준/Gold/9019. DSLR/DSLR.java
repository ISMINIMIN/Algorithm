import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		String cur;
		
		public Node(int num, String cur) {
			this.num = num;
			this.cur = cur;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			String answer = bfs(A, B);
			System.out.println(answer);
		}
	}

	private static String bfs(int A, int B) {
		boolean[] visited = new boolean[10000];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(A, ""));
		
		while(true) {
			 Node node = queue.poll();
			 
			 if(node.num == B) return node.cur;
			 
			 for(int i=0; i<4; i++) {
				 int num = 0;
				 String cur = "";
				 
				 if(i == 0) {
					 num = getD(node.num);
					 cur = "D";
				 } else if(i == 1) {
					 num = getS(node.num);
					 cur = "S";
				 } else if(i == 2) {
					 num = getL(node.num);
					 cur = "L";
				 } else if(i == 3) {
					 num = getR(node.num);
					 cur = "R";
				 }
				 
				 if(!visited[num]) {
					 queue.add(new Node(num, node.cur + cur));
					 visited[num] = true;
				 }
			 }
		}
	}

	private static int getR(int num) {
		return (num%10) * 1000 + num/10;
	}

	private static int getL(int num) {
		return (num%1000) * 10 + num/1000;
	}

	private static int getS(int num) {
		if(num == 0) return 9999;
		return num - 1;
	}

	private static int getD(int num) {
		if(num * 2 > 9999) return (num * 2) % 10000;
		return num * 2;
	}
}