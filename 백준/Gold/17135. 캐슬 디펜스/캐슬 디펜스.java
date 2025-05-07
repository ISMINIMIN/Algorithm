import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] board;
    static List<int[]> positions = new ArrayList<>();

    static int[] dy = {0, -1, 0};
    static int[] dx = {-1, 0, 1};

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Node {
        int y;
        int x;
        int distance;

        public Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        combine(0, 0, new int[3]);

        int max = 0;
        for (int[] position : positions) {
            int count = simulate(position);
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void combine(int start, int depth, int[] position) {
        if (depth == 3) {
            positions.add(position.clone());
            return;
        }

        for (int i = start; i < M; i++) {
            position[depth] = i;
            combine(i + 1, depth + 1, position);
        }
    }

    private static int simulate(int[] position) {
        int count = 0;
        int[][] simBoard = copy();

        for (int t = 0; t < N; t++) {
            boolean[][] marked = new boolean[N][M];

            for (int x : position) {
                Point point = attack(N, x, simBoard);
                if (point != null) {
                    marked[point.y][point.x] = true;
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (marked[y][x] && simBoard[y][x] == 1) {
                        simBoard[y][x] = 0;
                        count++;
                    }
                }
            }

            move(simBoard);
        }

        return count;
    }

    private static Point attack(int y, int x, int[][] simBoard) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Node(y - 1, x, 1));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.distance > D) break;

            if (isRange(now.y, now.x) && simBoard[now.y][now.x] == 1) {
                return new Point(now.y, now.x);
            }

            for (int d = 0; d < 3; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (isRange(ny, nx) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx, now.distance + 1));
                }
            }
        }

        return null;
    }

    private static void move(int[][] simBoard) {
        for (int i = N - 1; i > 0; i--) {
            simBoard[i] = simBoard[i - 1].clone();
        }

        Arrays.fill(simBoard[0], 0);
    }

    private static int[][] copy() {
        int[][] temp = new int[N][M];

        for (int y = 0; y < N; y++) {
            temp[y] = board[y].clone();
        }

        return temp;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
