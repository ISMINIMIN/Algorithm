import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[] computer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        max = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        computer = new int[N+1];
        list = new ArrayList<>();

        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
        }

        for(int i=1; i<N+1; i++) {
            hack(i);
        }

        for(int i=1; i<N+1; i++) {
            if(max < computer[i]) {
                max = computer[i];
            }
        }

        for(int i=1; i<N+1; i++) {
            if(max == computer[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void hack(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int com : list.get(now)) {
                if(!visited[com]) {
                    queue.add(com);
                    visited[com] = true;
                    computer[com]++;
                }
            }
        }
    }
}
