import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            String[] operation = operations[i].split(" ");
            int num = Integer.parseInt(operation[1]);
            
            if(operation[0].equals("I")) {
                minQueue.add(num);
                maxQueue.add(num);
            } else {
                if(minQueue.isEmpty()) continue;
                
                if(num == -1) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                } else {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
            }
        }
        
        if(minQueue.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        
        return answer;
    }
}