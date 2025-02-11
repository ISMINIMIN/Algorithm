import java.util.*;

class Solution {
    int userLen, bannedLen;
    boolean[] visited;
    boolean[][] checkId;
    Set<String> answer = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    
    public int solution(String[] user_id, String[] banned_id) {
        userLen = user_id.length;
        bannedLen = banned_id.length;
        
        visited = new boolean[userLen];
        checkId = new boolean[bannedLen][userLen];
        
        for(int i=0; i<bannedLen; i++) {
            for(int j=0; j<userLen; j++) {
                checkId[i][j] = compare(banned_id[i], user_id[j]);
            }
        }
        
        combine(0, user_id);
        
        return answer.size();
    }
    
    private void combine(int depth, String[] user_id) {
        if(depth == bannedLen) {
            for(int i=0; i<userLen; i++) {
                if(visited[i]) sb.append(user_id[i]);
            }
            
            answer.add(sb.toString());
            sb.setLength(0);
            
            return;
        }
        
        for(int i=0; i<userLen; i++) {
            if(checkId[depth][i] && !visited[i]) {
                visited[i] = true;
                combine(depth + 1, user_id);
                visited[i] = false;
            }
        }
    }
    
    private boolean compare(String bannedId, String userId) {
        if(bannedId.length() != userId.length()) return false;
        
        for(int i=0; i<bannedId.length(); i++) {
            char bc = bannedId.charAt(i);
            char uc = userId.charAt(i);
            
            if(bc != '*' && bc != uc) return false;
        }
        
        return true;
    }
}