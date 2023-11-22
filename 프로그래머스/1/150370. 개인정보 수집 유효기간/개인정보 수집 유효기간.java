import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termList = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        
        for(String term : terms) {
            String[] temp = term.split(" ");
            termList.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }
        
        
        int idx = 1;
        for(String privacy : privacies) {
            String[] temp = privacy.split(" ");
            String[] date = temp[0].split("\\.");
            int term = termList.get(temp[1]);
            int days = (year - Integer.parseInt(date[0])) * 12 * 28 +
                (month - Integer.parseInt(date[1])) * 28 +
                (day - Integer.parseInt(date[2]));
            if(days >= term) list.add(idx);
            idx++;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}