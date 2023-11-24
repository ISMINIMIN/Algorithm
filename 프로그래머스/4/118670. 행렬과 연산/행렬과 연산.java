import java.util.*;

class Solution {
    Deque<Integer> indexFirst = new LinkedList<>();
    Deque<Integer> indexLast = new LinkedList<>();
    Deque<Deque<Integer>> indexMid = new LinkedList<>();
    
    public int[][] solution(int[][] rc, String[] operations) {
        for(int i=0; i<rc.length; i++) {
            Deque<Integer> temp = new LinkedList<>();
            for(int j=0; j<rc[i].length; j++) {
                if(j == 0) indexFirst.add(rc[i][j]);
                else if(j == rc[i].length-1) indexLast.add(rc[i][j]);
                else temp.add(rc[i][j]);
            }
            indexMid.add(temp);
        }
        
        for(String operation : operations) {
            if(operation.equals("Rotate")) rotate();
            else shiftRow();
        }
        
        int[][] answer = new int[rc.length][rc[0].length];
        
        for(int i=0; i<rc.length; i++) {
            Deque<Integer> temp = indexMid.poll();
            for(int j=0; j<rc[i].length; j++) {
                if(j == 0) answer[i][j] = indexFirst.poll();
                else if(j == rc[i].length-1) answer[i][j] = indexLast.poll();
                else answer[i][j] = temp.poll();
            }
        }
        
        return answer;
    }
    
    private void shiftRow() {
        indexFirst.addFirst(indexFirst.pollLast());
        indexMid.addFirst(indexMid.pollLast());
        indexLast.addFirst(indexLast.pollLast());
    }
    
    private void rotate() {
        indexMid.peekFirst().addFirst(indexFirst.pollFirst());
        indexLast.addFirst(indexMid.peekFirst().pollLast());
        indexMid.peekLast().addLast(indexLast.pollLast());
        indexFirst.addLast(indexMid.peekLast().pollFirst());
    }
}