import java.util.*;

class Solution {
    
    public class Node {
        int current;
        int count;
        
        public Node(int current, int count) {
            this.current = current;
            this.count = count;
        }
    }
    
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));
        
        boolean[] visited = new boolean[y + 1];
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.current;
            int count = node.count;
            
            if(current == y) return count;
            
            if(current + n <= y && !visited[current + n]) {
                queue.add(new Node(current + n, count + 1));
                visited[current + n] = true;
            }
            
            if(current * 2 <= y && !visited[current * 2]) {
                queue.add(new Node(current * 2, count + 1));
                visited[current * 2] = true;
            }
            
            if(current * 3 <= y && !visited[current * 3]) {
                queue.add(new Node(current * 3, count + 1));
                visited[current * 3] = true;
            }
        }
        
        return -1;
    }
    
}
