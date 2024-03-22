import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            queue.add(work);
        }
        
        while(n > 0) {
            if(queue.isEmpty()) break;
            
            int temp = queue.poll();
            if(temp == 0) continue;
            queue.add(temp-1);
            n--;
        }
        
        long result = 0;
        while(!queue.isEmpty()) {
            result += Math.pow(queue.poll(), 2);
        }
        
        return result;
    }
}