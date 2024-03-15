import java.util.*;

class Solution {
    final String[] WORDS = {"A", "E", "I", "O", "U"};
    final int LEN = 5;
    
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs(word, "", 0);
        
        int result = 0;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                result = i;
                break;
            }
        }
        
        return result;
    }
    
    private void dfs(String word, String str, int depth) {
        list.add(str);
        
        if(depth == LEN) return;
        
        for(int i=0; i<LEN; i++) {
            dfs(word, str + WORDS[i], depth + 1);
        }
    }
}