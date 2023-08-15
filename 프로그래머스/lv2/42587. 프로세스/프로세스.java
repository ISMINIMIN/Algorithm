import java.util.*;

class Node {
    int value;
    int index;
    
    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        int answer = 0;
        int poll_idx = -1;
        int max_idx = priorities.length-1;
        
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Node(priorities[i], i));
        }
        
        Arrays.sort(priorities);
        
        while(poll_idx != location) {
            Node node = queue.poll();
            if(node.value != priorities[max_idx]) {
                queue.add(node);
            } else {
                answer++;
                poll_idx = node.index;
                if(max_idx >= 0) {
                    max_idx--;
                }
            }
        }
        
        return answer;
    }
}