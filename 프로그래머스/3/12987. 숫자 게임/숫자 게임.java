import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Queue<Integer> teamA = new PriorityQueue(Collections.reverseOrder());
        Deque<Integer> teamB = new ArrayDeque<>();
        
        for(int num : A) {
            teamA.add(num);
        }
        
        Arrays.sort(B);
        for(int num : B) {
            teamB.add(num);
        }
        
        while(!teamA.isEmpty()) {
            int numA = teamA.poll();
            
            if(numA < teamB.peekLast()) {
                teamB.pollLast();
                answer++;
            } else {
                teamB.pollFirst();
            }
        }
        
        return answer;
    }
}
