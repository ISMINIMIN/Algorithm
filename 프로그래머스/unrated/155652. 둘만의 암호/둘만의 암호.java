import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<skip.length(); i++) {
            list.add(skip.charAt(i));
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            while(count < index) {
                c++;
                if(c > 122) c -= 26;
                if(!list.contains(c)) count++;
            }
            sb.append(Character.toString(c));
        }
        
        return sb.toString();
    }
}