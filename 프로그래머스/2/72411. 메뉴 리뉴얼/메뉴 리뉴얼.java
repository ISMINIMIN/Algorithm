import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int len : course) {
            Map<String, Integer> menus = new HashMap<>();
            int max = 0;
            
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                comb(chars, 0, len, new StringBuilder(), menus);
            }
            
            for (int count : menus.values()) {
                max = Math.max(max, count);
            }
            
            if (max < 2) continue;
            
            for (String key : menus.keySet()) {
                if (menus.get(key) == max) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(String[]::new);
    }
    
    private void comb(char[] chars, int start, int depth, StringBuilder sb, Map<String, Integer> menus) {
        if (depth == 0) {
            String newMenu = sb.toString();
            menus.put(newMenu, menus.getOrDefault(newMenu, 0) + 1);
            return;
        }
        
        for (int i = start; i < chars.length; i++) {
            sb.append(chars[i]);
            comb(chars, i + 1, depth - 1, sb, menus);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}