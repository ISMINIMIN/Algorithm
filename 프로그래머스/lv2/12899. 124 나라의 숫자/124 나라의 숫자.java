class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int cur = n % 3;
            if(cur == 0) {
                sb.append("4");
                n = n / 3 - 1;
            }
            else {
                sb.append(Integer.toString(cur));
                n = n / 3;
            }
        }
        
        return sb.reverse().toString();
    }
}