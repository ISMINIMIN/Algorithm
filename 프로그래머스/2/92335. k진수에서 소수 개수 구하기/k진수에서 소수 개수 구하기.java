class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] nums = Long.toString(n, k).split("0");
        for(String num : nums) {
            if(isNumber(num)) {
                if(isPrime(Long.parseLong(num))) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private boolean isNumber(String num) {
        try {
            Long.parseLong(num);
        } catch(NumberFormatException e) {
            return false;
        }
        
        return true;
    }
    
    private boolean isPrime(long num) {
        if(num < 2) return false;
        
        for(int i=2; i<=(long)Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}