import java.util.*;

class Solution {
    int max = 0;
    boolean[] visited;
    List<Integer>[] list;
    int[] counts;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        counts = new int[n+1];

        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int[] temp : edge) {
            list[temp[0]].add(temp[1]);
            list[temp[1]].add(temp[0]);
        }

        bfs();

        for(int count : counts) {
            if(count == max) answer++;
        }

        return answer;
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int nextNode : list[current]) {
                if(!visited[nextNode]) {
                    counts[nextNode] = counts[current] + 1;
                    max = Math.max(max, counts[nextNode]);
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}