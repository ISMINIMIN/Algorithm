import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = 0;
        long left = 1;
        long right = (long)times[times.length - 1] * n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long people = calculate(times, mid);
            
            if(people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private long calculate(int[] times, long total) {
        long sum = 0;
        
        for(int time : times) {
            sum += total / time;
        }
        
        return sum;
    }
}