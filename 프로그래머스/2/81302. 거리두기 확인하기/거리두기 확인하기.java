import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int len = 5;
    
    class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[len];
        
        for(int p=0; p<len; p++) {
            char[][] currentPlace = new char[len][len];
            
            for(int i=0; i<len; i++) {
                String str = places[p][i];
                for(int j=0; j<len; j++) {
                    currentPlace[i][j] = str.charAt(j);
                }
            }
            
            boolean flag = true;
            for(int y=0; y<len; y++) {
                for(int x=0; x<len; x++) {
                    if(currentPlace[y][x] == 'P') {
                        flag = bfs(currentPlace, y, x);
                    }
                    if(!flag) break;
                }
                if(!flag) break;
            }
            
            if(flag) answer[p] = 1;
        }
        
        return answer;
    }
    
    private boolean bfs(char[][] place, int y, int x) {
        boolean[][] visited = new boolean[len][len];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for(int i=0; i<4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(isRange(ny, nx) && !visited[ny][nx]) {
                    int distance = distance(y, x, ny, nx);
                    if(distance <= 2) {
                        if(place[ny][nx] == 'P') return false;
                        else if(place[ny][nx] == 'O') {
                            queue.add(new Node(ny, nx));
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean isRange(int ny, int nx) {
        if(ny >= 0 && nx >= 0 && ny < len && nx < len) return true;
        return false;
    }
    
    private int distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }
}