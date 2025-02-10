import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;
        
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });

        for(int[] route : routes) {
            if(camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}
