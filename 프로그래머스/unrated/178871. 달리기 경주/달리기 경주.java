import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String str : callings) {
            int idx = map.get(str);
            String before = players[idx-1];
            
            players[idx] = before;
            players[idx-1] = str;
            
            map.put(before, idx);
            map.put(str, idx-1);
        }
        
        return players;
    }
}