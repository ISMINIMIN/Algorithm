import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static class Node {
		int idx;
		String operator;
		int leftNode;
		int rightNode;
		
		public Node(int idx, String operator, int leftNode, int rightNode) {
			super();
			this.idx = idx;
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
			
			int[] nums = new int[N+1];
			Stack<Node> stack = new Stack<>();
			
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				if(st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					stack.push(new Node(num, str, left, right));
				} else {
					nums[num] = Integer.parseInt(str);
				}
			}
			
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				if(node.operator.equals("-")) {
					nums[node.idx] = nums[node.leftNode] - nums[node.rightNode];
				} else if(node.operator.equals("+")) {
					nums[node.idx] = nums[node.leftNode] + nums[node.rightNode];
				} else if(node.operator.equals("*")) {
					nums[node.idx] = nums[node.leftNode] * nums[node.rightNode];
				} else if(node.operator.equals("/")) {
					nums[node.idx] = nums[node.leftNode] / nums[node.rightNode];
				}
			}
			
			System.out.println("#" + t + " " + nums[1]);
		}
	}
}