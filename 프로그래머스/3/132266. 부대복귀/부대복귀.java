import java.util.*;

class Solution {
    List<List<Integer>> list;
    
    public class Node {
        int road;
        int distance;
        
        public Node(int road, int distance) {
            this.road = road;
            this.distance = distance;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        initList(n, roads);
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = findPath(sources[i], destination, n);
        }
        
        return answer;
    }
    
    private int findPath(int start, int destination, int n) {
        if(start == destination) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(new Node(start, 0));
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int next : list.get(now.road)) {
                if(!visited[next]) {
                    if(next == destination) return now.distance + 1;
                    queue.add(new Node(next, now.distance + 1));
                    visited[next] = true;
                }
            }
        }
        
        return -1;
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
