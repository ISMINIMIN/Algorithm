import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int idx;
		int age;
		String name;
		
		public Node(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Node node) {
			if(this.age == node.age) return this.idx - node.idx;
			return this.age - node.age;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Node(i, age, name));
		}
		
		Collections.sort(list);
		
		for(Node node : list) {
			System.out.println(node.age + " " + node.name);
		}
	}
}