import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dy = { 0, 0, -1 };
    static int[] dx = { -1, 1, 0 };
	
    static int[][] arr;
    //사다리 아래서 위로
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int targetY = 0, targetX = 0; // 최종 목적지 좌표(출발 지점 좌표)

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            arr = new int[100][100];
            for (int i = 0; i < 100; i++) { // 행 번호, Y 좌표
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) { // 열 번호, X 좌표
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 2) { // 목적지 값을 만나면 좌표 저장
                        targetY = i;
                        targetX = j;
                    }
                }
            }
            int result = sadari(targetY, targetX);
            System.out.println("#" + T + " " + result);
        }
    }

    public static int sadari(int y, int x) {
        int ans = 0;
        while (true) {
            if (y == 0) { // 도착 지점 좌표는 행 번호 0
                ans = x;
                break;
            }
            for (int i = 0; i < 3; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (inRange(ny, nx) && arr[ny][nx] == 1) {
                    // 지나온 길 표시
                    arr[y][x] = 0;
                    y = ny;
					x = nx;
                }
            }
        }

        return ans;
    }

    public static boolean inRange(int y, int x) {
        return x >= 0 && y >= 0 && x < 100 && y < 100;
    }
	
}