import java.util.*;

class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    boolean[][] visited;
    
    class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> list = new ArrayList<>();
        String[][] map = new String[maps.length][maps[0].length()];
        
        for(int i=0; i<map.length; i++) {
            String[] str = maps[i].split("");
            for(int j=0; j<str.length; j++) {
                map[i][j] = str[j];
            }
        }
        
        for(int y=0; y<map.length; y++) {
            for(int x=0; x<map[0].length; x++) {
                if(!map[y][x].equals("X") && !visited[y][x]) {
                    int sum = bfs(y, x, map);
                    list.add(sum);
                }
            }
        }
        
        if(list.size() == 0) list.add(-1);
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int y, int x, String[][] map) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        int sum = Integer.parseInt(map[y][x]);
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length) {
                    if(!visited[ny][nx] && !map[ny][nx].equals("X")) {
                        queue.add(new Node(ny, nx));
                        sum += Integer.parseInt(map[ny][nx]);
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        
        return sum;
    }
}