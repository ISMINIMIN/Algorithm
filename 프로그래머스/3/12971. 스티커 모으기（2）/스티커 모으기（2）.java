class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len == 1) return sticker[0];
        
        return Math.max(calculate(sticker, 0, len-2), calculate(sticker, 1, len-1));
    }
    
    private int calculate(int[] sticker, int start, int end) {
        int prev2 = 0, prev1 = 0;
        
        for(int i=start; i<=end; i++) {
            int current = Math.max(prev1, prev2 + sticker[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}