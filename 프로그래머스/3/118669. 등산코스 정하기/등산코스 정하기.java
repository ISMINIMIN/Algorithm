import java.util.*;

class Solution {
    List<Node> list[];
    
    class Node {
        int point;
        int time;
        
        public Node(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] path : paths) {
            int point1 = path[0];
            int point2 = path[1];
            int time = path[2];
            
            // 시작지점이 출입구이거나, 도착지점이 산봉우리일 경우 단방향
            // 시작지점이 산봉우리이거나, 도착지점이 출입구일 경우 단방향
            if(isGate(point1, gates) || isSummit(point2, summits)) {
                list[point1].add(new Node(point2, time));
            } else if(isGate(point2, gates) || isSummit(point1, summits)) {
                list[point2].add(new Node(point1, time));
            } else {
                list[point1].add(new Node(point2, time));
                list[point2].add(new Node(point1, time));
            }
        }
        
        return dijkstra(n, gates, summits);
    }
    
    private int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> queue = new LinkedList<>();
        int[] intensity = new int[n+1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 출입구 전부를 큐에 넣음
        for(int gate : gates) {
            queue.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.time > intensity[node.point]) continue;

            for(int i=0; i<list[node.point].size(); i++) {
                Node nextNode = list[node.point].get(i);

                int distance = Math.max(intensity[node.point], nextNode.time);
                if(intensity[nextNode.point] > distance) {
                    intensity[nextNode.point] = distance;
                    queue.add(new Node(nextNode.point, distance));
                }
            }
        }

        int minPoint = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for(int summit : summits) {
            if(intensity[summit] < minTime) {
                minPoint = summit;
                minTime = intensity[summit];
            }
        }

        return new int[]{minPoint, minTime};
    }
    
    private boolean isGate(int point, int[] gates) {
        for(int gate : gates) {
            if(gate == point) return true;
        }
        return false;
    }
    
    private boolean isSummit(int point, int[] summits) {
        for(int summit : summits) {
            if(summit == point) return true;
        }
        return false;
    }
}