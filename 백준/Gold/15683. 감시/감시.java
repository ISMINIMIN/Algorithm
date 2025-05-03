import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min;
    static int[][] office;
    static List<CCTV> cctvs = new ArrayList<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][][] cctvDirs = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    static class CCTV {
        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        office = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                office[y][x] = Integer.parseInt(st.nextToken());
                if (office[y][x] >= 1 && office[y][x] <= 5) {
                    cctvs.add(new CCTV(y, x, office[y][x]));
                }
            }
        }

        dfs(0);

        System.out.println(min);
    }

    static void dfs(int depth) {
        if (depth == cctvs.size()) {
            min = Math.min(min, count());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int[][] dirs = cctvDirs[cctv.type];

        for (int[] dir : dirs) {
            int[][] temp = copy();

            for (int d : dir) {
                watch(cctv.y, cctv.x, d);
            }

            dfs(depth + 1);

            office = temp;
        }
    }

    static void watch(int y, int x, int d) {
        int ny = y;
        int nx = x;

        while (true) {
            ny += dy[d];
            nx += dx[d];

            if (!isRange(ny, nx)) break;
            if (office[ny][nx] == 6) break;

            if (office[ny][nx] == 0) office[ny][nx] = 7;
        }
    }

    static int count() {
        int count = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (office[y][x] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static int[][] copy() {
        int[][] temp = new int[N][M];

        for (int y = 0; y < N; y++) {
            temp[y] = office[y].clone();
        }

        return temp;
    }

    static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
