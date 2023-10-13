class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minMoves = len - 1;
        
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            
            int moveUp = c - 'A';
            int moveDown = 'Z' - c + 1;
            answer += Math.min(moveUp, moveDown);
            
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            int moves = 2 * i + len - next;
            minMoves = Math.min(minMoves, moves);
            
            moves = (len - next) * 2 + i;
            minMoves = Math.min(minMoves, moves);
        }
        
        answer += minMoves;
        
        return answer;
    }
}