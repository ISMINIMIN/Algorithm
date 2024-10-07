import java.util.*;

class Solution {
    PriorityQueue<Integer> queue;
    
    public int solution(int[] scoville, int K) {
        setQueue(scoville);
        return makeFood(K);
    }
    
    private void setQueue(int[] scoville) {
        queue = new PriorityQueue<>();
        
        for(int val : scoville) {
            queue.add(val);
        }
    }
    
    private int makeFood(int K) {
        int cnt = 0;
        
        while(queue.peek() < K) {
            if(queue.size() == 1) return -1;
            
            queue.add(queue.poll() + (queue.poll() * 2));
            cnt++;
        }
        
        return cnt;
    }
}