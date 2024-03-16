import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] results = new int[prices.length];
		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				results[stack.peek()] = i - stack.peek();
				stack.pop();
			}
            
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			results[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
        
		return results;
    }
}
