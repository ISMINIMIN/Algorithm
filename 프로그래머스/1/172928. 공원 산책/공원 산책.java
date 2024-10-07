import java.util.*;

class Solution {
    final int[] dy = {0, 0, 1, -1};
    final int[] dx = {1, -1, 0, 0};
    
    int H, W;
    char[][] map;
    int[] now;
    
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        
        setMap(park);
        
        for(String route : routes) {
            move(route);
        }
        
        return now;
    }
    
    private void setMap(String[] park) {
        map = new char[H][W];
        now = new int[2];
        
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                char temp = park[i].charAt(j);
                map[i][j] = temp;
                if(temp == 'S') {
                    now[0] = i;
                    now[1] = j;
                }
            }
        }
    }
    
    private void move(String route) {
        char dirChar = route.charAt(0);
        int cnt = route.charAt(2) - '0';
        int dir = changeDir(dirChar);
        
        int[] next = new int[2];
        next[0] = now[0];
        next[1] = now[1];
        
        while(cnt-- > 0) {
            next[0] += dy[dir];
            next[1] += dx[dir];
            
            if(!isRange(next[0], next[1]) || map[next[0]][next[1]] == 'X') {
                next = now;
                break;
            }
        }
        
        now[0] = next[0];
        now[1] = next[1];
    }
    
    private int changeDir(char dirChar) {
        int dir = -1;
        
        switch(dirChar) {
            case 'E': 
                dir = 0;
                break;
            case 'W': 
                dir = 1;
                break;
            case 'S': 
                dir = 2;
                break;
            case 'N': 
                dir = 3;
                break;
            default:
                break;
        }
        
        return dir;
    }
    
    private boolean isRange(int y, int x) {
        return x >= 0 && y >= 0 && x < W && y < H;
    }
}