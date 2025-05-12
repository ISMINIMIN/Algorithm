class Solution {
    int y = 5, x = 5;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    boolean[][][] visited = new boolean[11][11][4];
    
    public int solution(String dirs) {
        int count = 0;
        
        for (char dir : dirs.toCharArray()) {
            int d = "UDRL".indexOf(dir);
            if (move(d)) count++;
        }
        
        return count;
    }
    
    private boolean move(int d) {
        int ny = y + dy[d];
        int nx = x + dx[d];
            
        if (!isRange(ny, nx)) return false;
        
        boolean isNew = !visited[y][x][d];
        
        if (isNew) {
            visited[y][x][d] = true;
            visited[ny][nx][opposite(d)] = true;
        }
            
        y = ny;
        x = nx;
        
        return isNew;
    }
    
    private boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < 11 && x < 11;
    }
    
    private int opposite(int d) {
        return d % 2 == 0 ? d + 1 : d - 1;
    }
}