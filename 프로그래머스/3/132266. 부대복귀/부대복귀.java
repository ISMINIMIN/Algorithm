import java.util.*;

class Solution {
    List<List<Integer>> list;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        initList(n, roads);
        
        int[] distances = findPath(destination, n);
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        
        return answer;
    }
    
    private int[] findPath(int start, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : list.get(now)) {
                if(distances[next] == -1) {
                    queue.add(next);
                    distances[next] = distances[now] + 1;
                }
            }
        }
        
        return distances;
    }
    
    private void initList(int n, int[][] roads) {
        list = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            int start = road[0];
            int end = road[1];

            list.get(start).add(end);
            list.get(end).add(start);
        }
    }
}
