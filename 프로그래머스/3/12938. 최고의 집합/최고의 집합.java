import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[] {-1};
        
        int[] result = new int[n];
        int divide = n;
        
        for(int i=0; i<n; i++) {
            result[i] = s / divide--;
            s -= result[i];
        }
        
        Arrays.sort(result);
        
        return result;
    }
}