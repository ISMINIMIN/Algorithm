import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length + 2];
        
        dp[0][1] = triangle[0][0];
        for(int i=1; i<triangle.length; i++) {
            for(int j=1; j<=i+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j-1];
            }
        }
        
        int max = 0;
        for(int i=1; i<triangle.length+1; i++) {
            max = Math.max(max, dp[triangle.length-1][i]);
        }
        
        return max;
    }
}