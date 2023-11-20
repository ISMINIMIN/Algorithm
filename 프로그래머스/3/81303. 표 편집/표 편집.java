import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> buffer = new Stack<>();
        int size = n;
        
        for(String str : cmd) {
            if(str.equals("C")) {
                buffer.push(k);
                size--;
                if(k == size) k--;
            } else if(str.equals("Z")) {
                if(buffer.pop() <= k) k++;
                size++;
            } else {
                String[] arr = str.split(" ");
                if(arr[0].equals("U")) k -= Integer.parseInt(arr[1]);
                else k += Integer.parseInt(arr[1]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            sb.append("O");
        }
        
        while(!buffer.isEmpty()) {
            sb.insert(buffer.pop(), "X");
        }
        
        return sb.toString();
    }
}