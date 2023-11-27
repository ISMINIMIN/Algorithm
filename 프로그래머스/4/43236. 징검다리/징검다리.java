import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1; // 최소 간격
        int right = distance; // 최대 간격
        
        while(left <= right) {
            int mid = (left+right) / 2;
            int delete = 0;
            int temp = 0;
            
            for(int i=0; i<rocks.length; i++) {
                if(rocks[i] - temp < mid) {
                    delete++;
                    continue;
                }
                
                temp = rocks[i];
                
                if(distance - temp < mid) {
                    delete++;
                }
            }
            
            if(delete <= n) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}