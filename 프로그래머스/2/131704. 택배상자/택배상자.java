import java.util.*;

class Solution {
    int result = 0;
    int idx = 0;
    Stack<Integer> temp;
    
    public int solution(int[] order) {
        temp = new Stack<>();
        
        checkMainBelt(order);
        checkTempBelt(order);
        
        return result;
    }
    
    private void checkMainBelt(int[] order) {
        for(int i=1; i<=order.length; i++) {
            if(order[idx] == i) {
                result++;
                idx++;
            }
            
            else if(!temp.isEmpty() && temp.peek() == order[idx]) {
                temp.pop();
                result++;
                idx++;
                i--;
            }
            
            else {
                temp.add(i);
            }
        }
    }
    
    private void checkTempBelt(int[] order) {
        while(!temp.isEmpty()) {
            if(temp.pop() == order[idx++]) result++;
            else break;
        }
    }
}
