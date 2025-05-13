import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> count = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            if (!count.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                count.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                count.put(genres[i], count.get(genres[i]) + plays[i]);
            }
        }
        
        List<String> genreList = new ArrayList<>(count.keySet());
        Collections.sort(genreList, (s1, s2) -> count.get(s2) - count.get(s1));
        
        for (String genre : genreList) {
            Map<Integer, Integer> playList = music.get(genre);
            List<Integer> playIdx = new ArrayList<>(playList.keySet());
            Collections.sort(playIdx, (s1, s2) -> playList.get(s2) - playList.get(s1));
            
            answer.add(playIdx.get(0));
            if (playIdx.size() > 1) answer.add(playIdx.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}