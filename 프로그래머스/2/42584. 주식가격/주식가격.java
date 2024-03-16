import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] results = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++) {
            int count = 0;
            for(int j=i+1; j<prices.length; j++) {
                results[i]++;
                if(prices[j] < prices[i]) break;
            }
        }
        
        return results;
    }
}