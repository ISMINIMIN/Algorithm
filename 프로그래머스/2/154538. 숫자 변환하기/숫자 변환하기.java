import java.util.*;

class Solution {
    boolean[] visited;
    Queue<Node> queue;
    
    public class Node {
        int current;
        int count;
        
        public Node(int current, int count) {
            this.current = current;
            this.count = count;
        }
    }
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n) {
        queue = new LinkedList<>();
        queue.add(new Node(x, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.current;
            int count = node.count;
            
            if(current == y) return count;
            
            addQueue(y, current + n, count);
            addQueue(y, current * 2, count);
            addQueue(y, current * 3, count);
        }
        
        return -1;
    }
    
    private void addQueue(int y, int next, int count) {
        if(next <= y && !visited[next]) {
            queue.add(new Node(next, count + 1));
            visited[next] = true;
        }
    }
}
