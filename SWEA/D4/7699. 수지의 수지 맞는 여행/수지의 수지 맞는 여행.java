import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int y;
	int x;
	
	Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class Solution {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] map;
	static boolean[] visited_ap;
	static boolean[][] visited;
	static int max;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            map = new char[R][C];
            visited = new boolean[R][C];
            visited_ap = new boolean[26];
            
            for(int i=0; i<R; i++) {
            	String str = br.readLine();
            	for(int j=0; j<C; j++) {
            		map[i][j] = str.charAt(j);
            	}
            }
            
            max = 0;
            visited_ap[map[0][0] - 'A'] = true;
            visited[0][0] = true;
            dfs(0, 0, 1);
            
            System.out.println("#" + t + " " + max);
		}
    }

	public static void dfs(int y, int x, int count) {
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(check(ny, nx) && !visited[ny][nx]) {
				if(!visited_ap[map[ny][nx] - 'A']) {
					visited[ny][nx] = true;
					visited_ap[map[ny][nx] - 'A'] = true;
					dfs(ny, nx, count+1);
					visited_ap[map[ny][nx] - 'A'] = false;
					visited[ny][nx] = false;
				}
			}
		}
		
		max = Math.max(max, count);
	}

	public static boolean check(int ny, int nx) {
		if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length) return true;
		return false;
	}
}