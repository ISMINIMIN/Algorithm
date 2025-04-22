class Solution {
    final int ATTACK = 1;
    
    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int col = board[0].length;
        
        int[][] sum = new int[row + 1][col + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = s[5];
            
            if (type == ATTACK) degree *= -1;
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        applyPrefixSum(sum, row, col);
        
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
    
    private void applyPrefixSum(int[][] sum, int row, int col) {
        for (int i = 0; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        for (int j = 0; j <= col; j++) {
            for (int i = 1; i <= row; i++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
    }
}