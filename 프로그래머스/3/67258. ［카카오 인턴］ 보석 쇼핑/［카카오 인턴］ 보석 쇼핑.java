import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> jewelCount = new HashMap<>();
        Set<String> jewelSet = new HashSet<>(Arrays.asList(gems));
        
        int len = gems.length;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while(end < len) {
            jewelCount.put(gems[end], jewelCount.getOrDefault(gems[end], 0) + 1);
            end++;

            while(jewelCount.size() == jewelSet.size()) {
                if(end - start < min) {
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                
                jewelCount.put(gems[start], jewelCount.get(gems[start]) - 1);
                
                if(jewelCount.get(gems[start]) == 0) {
                    jewelCount.remove(gems[start]);
                }
                
                start++;
            }
        }

        return answer;
    }
}