import java.util.*;

class Solution {
    int N;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int[][][] visited;
    
    final int STRAIGHT = 100;
    final int CORNER = 500;
    final int WALL = 1;
    
    class Node {
        int y;
        int x;
        int dir;
        int cost;
        
        public Node(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][4];
        
        for(int[][] dir : visited) {
            for(int[] value : dir) {
                Arrays.fill(value, Integer.MAX_VALUE);
            }
        }
        
        return bfs(board);
    }
    
    private int bfs(int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        queue.add(new Node(0, 0, 3, 0));
        visited[0][0][1] = 0;
        visited[0][0][3] = 0;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int d=0; d<4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                
                if(!isRange(ny, nx) || board[ny][nx] == WALL) continue;
                
                int nextCost = now.cost + STRAIGHT;
                if(now.dir != d) nextCost += CORNER;

                if(visited[ny][nx][d] > nextCost) {
                    visited[ny][nx][d] = nextCost;
                    queue.add(new Node(ny, nx, d, nextCost));
                }
            }
        }
        
        return Arrays.stream(visited[N-1][N-1]).min().getAsInt();
    }
    
    private boolean isRange(int y, int x) {
        return y >=0 && x >= 0 && y < N && x < N;
    }
}
