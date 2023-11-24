import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        
        int count = 0;
        while(true) {
            if(q1.isEmpty() || q2.isEmpty()) return -1;
            if(count > (q1.size() + q2.size()) * 2) return -1;
            if(sum1 == sum2) break;
            
            int temp = 0;
            if(sum1 > sum2) {
                temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            } else {
                temp = q2.poll();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
            }
            
            count++;
        }
        
        return count;
    }
}