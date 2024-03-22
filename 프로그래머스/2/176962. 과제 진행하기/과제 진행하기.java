import java.util.*;

class Solution {
    class Task implements Comparable<Task> {
        private String name;
        private int startTime;
        private int requiredTime;
        
        public Task(String name, int requiredTime) {
            this.name = name;
            this.requiredTime = requiredTime;
        }
        
        public Task(String name, int startTime, int requiredTime) {
            this.name = name;
            this.startTime = startTime;
            this.requiredTime = requiredTime;
        }
        
        @Override
        public int compareTo(Task t) {
			return this.startTime - t.startTime;
		}
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Task> queue = new PriorityQueue<>();
        Stack<Task> buffer = new Stack<>();
        List<String> result = new ArrayList<>();
        
        int index = 1;
        for(String[] plan : plans) {
            String name = plan[0];
            int startTime = changeTime(plan[1]);
            int requiredTime = Integer.parseInt(plan[2]);
            queue.add(new Task(name, startTime, requiredTime));
        }
        
        while(!queue.isEmpty()) {
            Task now = queue.poll();
            String name = now.name;
            int startTime = now.startTime;
            int requiredTime = now.requiredTime;
            
            int currentTime = startTime;
            
            if(!queue.isEmpty()) {
                Task next = queue.peek();
                
                if(startTime + requiredTime > next.startTime) {
                    buffer.push(new Task(name, requiredTime - (next.startTime - currentTime)));
                }
                
                else if(startTime + requiredTime == next.startTime) {
                    result.add(name);
                    continue;
                }
                
                else {
                    result.add(name);
                    currentTime += requiredTime;
                    
                    while(!buffer.isEmpty()) {
                        Task bufferTask = buffer.pop();
                        
                        if(currentTime + bufferTask.requiredTime <= next.startTime) {
                            currentTime += bufferTask.requiredTime;
                            result.add(bufferTask.name);
                        }
                        
                        else {
                            buffer.push(new Task(bufferTask.name, bufferTask.requiredTime - (next.startTime - currentTime)));
                            break;
                        }
                    }
                }
            }
            
            else {
                result.add(name);
                
                if(!buffer.isEmpty()) {
                    while(!buffer.isEmpty()) {
                        Task bufferTask = buffer.pop();
                        result.add(bufferTask.name);
                    }
                }
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    private int changeTime(String time) {
        String[] temp = time.split(":");
        int hh = Integer.parseInt(temp[0]);
        int mm = Integer.parseInt(temp[1]);
        
        return hh * 60 + mm;
    }
}