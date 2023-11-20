class Solution {
    public String solution(String cipher, int code) {
        String[] arr = cipher.split("");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++) {
            if((i+1) % code == 0) sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}