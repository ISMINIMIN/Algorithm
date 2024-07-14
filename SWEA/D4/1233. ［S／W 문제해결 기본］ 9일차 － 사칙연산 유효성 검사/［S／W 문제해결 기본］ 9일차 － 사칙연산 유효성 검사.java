import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		int value;
		String operator;
		int leftNode;
		int rightNode;
		
		public Node(String operator, int leftNode, int rightNode) {
			super();
			this.operator = operator;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[N];
			boolean flag = true;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String str = st.nextToken();
				
				if(st.hasMoreTokens( )) {
					int left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens( )) {
						int right = Integer.parseInt(st.nextToken());
						nodes[i] = new Node(str, left, right);
					} else {
						nodes[i] = new Node(str, left, 0);
					}
				} else {
					nodes[i] = new Node(str, 0, 0);
				}
			}
			
			for(int i=0; i<N; i++) {
				if(nodes[i].operator.equals("-") || nodes[i].operator.equals("+") || nodes[i].operator.equals("*") || nodes[i].operator.equals("/")) {
					if(nodes[i].leftNode == 0 || nodes[i].rightNode == 0) {
						flag = false;
						break;
					}
				} else {
					if(nodes[i].leftNode != 0 || nodes[i].rightNode != 0) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) System.out.println("#" + t + " 1");
			else System.out.println("#" + t + " 0");
		}
	}
}
