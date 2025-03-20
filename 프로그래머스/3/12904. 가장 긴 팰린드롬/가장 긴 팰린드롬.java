class Solution {
    public int solution(String s) {
        for(int len=s.length(); len>0; len--) {
            for(int start=0; start+len<=s.length(); start++) {
                if(isPalindrome(start, start+len-1, s)) return len;
            }
        }
        
        return 0;
    }
    
    private boolean isPalindrome(int start, int end, String s) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}