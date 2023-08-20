import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int i : ingredient) {
            stack.push(i);
            
            if(stack.size() >= 4) {
                int one = stack.get(stack.size() - 4);
                int two = stack.get(stack.size() - 3);
                int three = stack.get(stack.size() - 2);
                int four = stack.get(stack.size() - 1);
                
                if(one == 1 && two == 2 && three == 3 && four == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        
        return answer;
    }
}