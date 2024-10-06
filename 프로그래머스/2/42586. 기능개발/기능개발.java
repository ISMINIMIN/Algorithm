import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            queue.add((int)Math.ceil((100.0-progresses[i]) / speeds[i]));
        }
           
        int count = 1;  
        int now = queue.poll();
        List<Integer> complete = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int next = queue.poll();
            if(now >= next) count++;
            else {
                complete.add(count);
                now = next;
                count = 1; 
            }
        }
        
        complete.add(count);

        int[] answer = complete.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}