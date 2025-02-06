import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int[][] board;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    final static int WALL = 1;
    final static int CLEANED = 2;
    final static int NOT_CLEANED = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        count = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(y, x, d);

        sb.append(count);
        System.out.println(sb);
    }

    private static void clean(int y, int x, int d) {
        while(true) {
            if(board[y][x] == NOT_CLEANED) {
                board[y][x] = CLEANED;
                count++;
            }

            boolean flag = false;
            for(int i=0; i<4; i++) {
                d = (d + 3) % 4;
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(isRange(ny, nx) && board[ny][nx] == NOT_CLEANED) {
                    y = ny;
                    x = nx;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                int backDir = (d + 2) % 4;
                int ny = y + dy[backDir];
                int nx = x + dx[backDir];

                if(isRange(ny, nx) && board[ny][nx] != WALL) {
                    y = ny;
                    x = nx;
                }

                else break;
            }
        }
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
