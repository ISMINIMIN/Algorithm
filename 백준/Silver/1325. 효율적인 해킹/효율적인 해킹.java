import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int[] visited, computer;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        max = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        computer = new int[N+1];
        list = new ArrayList<>();

        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(B).add(A);
        }

        for(int i=1; i<N+1; i++) {
            visited[i] = i;
            hack(i, i);
            max = Math.max(max, computer[i]);
        }

        for(int i=1; i<N+1; i++) {
            if(max == computer[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void hack(int start, int now) {
        for(int next : list.get(now)) {
            if(visited[next] != start) {
                visited[next] = start;
                computer[start]++;
                hack(start, next);
            }
        }
    }
}
