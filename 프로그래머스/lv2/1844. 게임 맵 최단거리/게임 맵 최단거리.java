import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    boolean[][] visited;
    int yLen, xLen;
    
    class Node {
        int y;
        int x;
        int count;
        
        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        yLen = maps.length;
        xLen = maps[0].length;
        visited = new boolean[yLen][xLen];
        
        return bfs(0, 0, maps);
    }
    
    private int bfs(int y, int x, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, 1));
        visited[y][x] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.y == yLen-1 && node.x == xLen-1) {
                return node.count;
            }
            
            for(int i=0; i<4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(isRange(ny, nx)) {
                    if(maps[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.add(new Node(ny, nx, node.count+1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isRange(int ny, int nx) {
        if(ny >= 0 && nx >= 0 && ny < yLen && nx < xLen)
            return true;
        return false;
    }
}