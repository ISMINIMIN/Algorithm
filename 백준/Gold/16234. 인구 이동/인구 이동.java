import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] countries;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        countries = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                countries[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (move()) day++;

        System.out.println(day);
    }

    private static boolean move() {
        visited = new boolean[N][N];
        boolean isMoved = false;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    List<int[]> list = new ArrayList<>();
                    int sum = union(y, x, list);
                    
                    if (list.size() > 1) {
                        isMoved = true;
                        int avg = sum / list.size();
                        for (int[] pos : list) {
                            countries[pos[0]][pos[1]] = avg;
                        }
                    }
                }
            }
        }

        return isMoved;
    }

    private static int union(int y, int x, List<int[]> list) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        list.add(new int[]{y, x});
        visited[y][x] = true;

        int sum = countries[y][x];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (isRange(ny, nx) && !visited[ny][nx]) {
                    int diff = Math.abs(countries[cy][cx] - countries[ny][nx]);

                    if (diff >= L && diff <= R) {
                        queue.add(new int[]{ny, nx});
                        list.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        sum += countries[ny][nx];
                    }
                }
            }
        }

        return sum;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
