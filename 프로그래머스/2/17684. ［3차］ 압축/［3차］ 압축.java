import java.util.*;

class Solution {
    Map<String, Integer> dictionary;
    List<Integer> indexList;
    int index = 27;
    
    public int[] solution(String msg) {
        dictionary = new HashMap<>();
        initDictionary();
        
        indexList = new ArrayList<>();
        LZW(msg);
        
        return indexList.stream().mapToInt(i -> i).toArray();
    }
    
    private void LZW(String msg) {
        int i = 0;
        
        while (i < msg.length()) {
            int j = i;
            String w = "";
            
            while (j < msg.length()) {
                String c = msg.substring(i, j + 1);
                
                if (dictionary.containsKey(c)) {
                    w = c;
                    j++;
                } else {
                    break;
                }
            }
            
            indexList.add(dictionary.get(w));
            
            if (j < msg.length()) {
                String wc = msg.substring(i, j + 1);
                dictionary.put(wc, index++);
            }

            i = j;
        }
    }
    
    private void initDictionary() {
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), i + 1);
        }
    }
}