class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int current = 1;
        int coverage = 2 * w + 1;

        for(int station : stations) {
            int start = station - w;
            int end = station + w;
            
            if(start > current) {
                int gap = start - current;
                answer += (int)(Math.ceil((double) gap / coverage));
            }
            
            current = end + 1;
        }
        
        if(current <= n) {
            int gap = n - current + 1;
            answer += (int)(Math.ceil((double) gap / coverage));
        }
        
        return answer;
    }
}
