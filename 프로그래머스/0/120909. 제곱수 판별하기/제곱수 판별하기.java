class Solution {
    public int solution(int n) {
        int sqrt = (int)Math.sqrt(n);
        int sqrt_ceil = (int)Math.ceil(Math.sqrt(n));
        
        return sqrt == sqrt_ceil ? 1 : 2;
    }
}