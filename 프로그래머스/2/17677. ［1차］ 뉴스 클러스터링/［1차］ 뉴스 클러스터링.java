import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> multiSet1 = makeMultiSet(str1);
        Map<String, Integer> multiSet2 = makeMultiSet(str2);

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(multiSet1.keySet());
        allKeys.addAll(multiSet2.keySet());

        int intersection = 0;
        int union = 0;

        for (String key : allKeys) {
            int count1 = multiSet1.getOrDefault(key, 0);
            int count2 = multiSet2.getOrDefault(key, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        if (union == 0) return 65536;
        return (int) ((intersection / (double) union) * 65536);
    }

    private Map<String, Integer> makeMultiSet(String str) {
        str = str.toLowerCase();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String key = "" + c1 + c2;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        return map;
    }
}