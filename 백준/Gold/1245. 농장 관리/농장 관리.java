import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<M; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(!visited[y][x]) {
                    if(isPeak(y, x)) {
                        answer++;
                    }
                }
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }

    private static boolean isPeak(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        boolean flag = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int d=0; d<8; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if(isRange(ny, nx)) {
                    if(!visited[ny][nx] && board[ny][nx] == board[y][x]) {
                        queue.add(new Node(ny, nx));
                        visited[ny][nx] = true;
                    }

                    if(flag && board[node.y][node.x] < board[ny][nx]) {
                        flag = false;
                    }
                }
            }
        }

        return flag;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
