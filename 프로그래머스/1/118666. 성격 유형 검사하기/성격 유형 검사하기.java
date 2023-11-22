import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] types = {"RT", "CF", "JM", "AN"};
        
        for(String type : types) {
            map.put(type.charAt(0), 0);
            map.put(type.charAt(1), 0);
        }
        
        for(int i=0; i<survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            int score = choices[i] - 4;
            if(score < 0) map.put(c1, map.getOrDefault(c1, 0) + Math.abs(score));
            else if(score > 0) map.put(c2, map.getOrDefault(c2, 0) + score);
        }
        
        for(String type : types) {
            char c1 = type.charAt(0);
            char c2 = type.charAt(1);
            int v1 = map.get(c1);
            int v2 = map.get(c2);
            if(v1 == v2) {
                if(c1 < c2) sb.append(c1);
                else sb.append(c2);
            } else if(v1 < v2) {
                sb.append(c2);
            } else {
                sb.append(c1);
            }
        }
        
        return sb.toString();
    }
}