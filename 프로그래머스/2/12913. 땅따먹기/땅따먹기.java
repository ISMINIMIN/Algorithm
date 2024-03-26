import java.util.*;

class Solution {
    final int LEN = 4;
    
    int solution(int[][] land) {
        int result = 0;
        
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<LEN; j++) {
                land[i][j] += calculateMax(land, i, j);
            }
        }
        
        for(int i=0; i<LEN; i++) {
            result = Math.max(result, land[land.length-1][i]);
        }

        return result;
    }
    
    private int calculateMax(int[][] land, int row, int index) {
        int max = 0;
        
        for(int i=0; i<LEN; i++) {
            if(i == index) continue;
            max = Math.max(max, land[row-1][i]);
        }
        
        return max;
    }
}