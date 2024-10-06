import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        final int COMPLETE = 100;
        
        Queue<Work> queue = new LinkedList<>();
        Map<Integer, Integer> complete = new TreeMap<>();
        
        int count = 0;
        
        for(int i=0; i<progresses.length; i++) {
            queue.add(new Work(progresses[i], speeds[i]));
        }
        
        while(!queue.isEmpty()) {
            Work work = queue.peek();
            
            if(!work.flag && count != 0) {
                work.setting(count);
            }
            
            if(work.progress >= COMPLETE) {
                queue.poll();
                complete.put(count, complete.getOrDefault(count, 0) + 1);
                continue;
            }
            
            work.working();
            count++;
        }
        
        int[] answer = complete.values()
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}

class Work {
    int progress;
    int speed;
    boolean flag = false;
    
    public Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
    
    public void setting(int count) {
        progress += speed * count;
    }
    
    public void working() {
        progress += speed;
        flag = true;
    }
}
