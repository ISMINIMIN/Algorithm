import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int val : scoville) {
            queue.add(val);
        }
        
        int answer = 0;
        int current = 0;
        
        while(queue.peek() < K) {
            if(queue.size() == 1) {
                answer = -1;
                break;
            }
            queue.add(queue.poll() + (queue.poll() * 2));
            answer++;
        }
        
        return answer;
    }
}