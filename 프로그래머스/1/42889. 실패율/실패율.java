import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int players = stages.length;
        int failedPlayer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Stage> answer = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            map.put(i, 0);
        }

        for(int stage : stages) {
            if(stage <= N) {
                map.put(stage, map.get(stage) + 1);
            }
        }

        for(int key=1; key<=N; key++) {
            if(players - failedPlayer > 0) {
                answer.add(new Stage(key, map.get(key) / (double)(players - failedPlayer)));
            } else {
                answer.add(new Stage(key, 0.0));
            }
            
            failedPlayer += map.get(key);
        }

        return answer.stream().sorted().mapToInt(f -> f.number).toArray();
    }

    class Stage implements Comparable<Stage> {
        int number;
        double rate;

        public Stage(int number, double rate) {
            this.number = number;
            this.rate = rate;
        }

        @Override
        public int compareTo(Stage s) {
            return Double.compare(s.rate, this.rate) == 0 ? this.number - s.number : Double.compare(s.rate, this.rate);
        }
    }
}
