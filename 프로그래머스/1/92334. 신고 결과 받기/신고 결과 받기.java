import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> result = new HashMap<>();
        Map<String, Integer> users = new HashMap<>();
        
        int[] answer = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++) {
            result.put(id_list[i], new HashSet<>());
            users.put(id_list[i], i);
        }
        
        for(String temp : report) {
            String from = temp.split(" ")[0];
            String to = temp.split(" ")[1];
            result.get(to).add(from);
        }
        
        for(String to : result.keySet()) {
            if(result.get(to).size() >= k) {
                for(String from : result.get(to)) {
                    answer[users.get(from)]++;
                }
            }
        }
        
        return answer;
    }
}