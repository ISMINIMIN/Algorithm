class Solution {
    int[] count = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(0, 0, arr.length, arr);
        return count;
    }
    
    private void compress(int y, int x, int size, int[][] arr) {
        if (isSame(y, x, size, arr)) {
            count[arr[y][x]]++;
            return;
        }
        
        int half = size / 2;
        
        compress(y, x, half, arr);
        compress(y + half, x, half, arr);
        compress(y, x + half, half, arr);
        compress(y + half, x + half, half, arr);
    }
    
    private boolean isSame(int y, int x, int size, int[][] arr) {
        int val = arr[y][x];
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        
        return true;
    }
}