import java.util.*;

class Solution {
    int[] root;
    public int solution(int n, int[][] computers) {
        root = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1 && i != j) {
                    if(find(i) != find(j)) {
                        union(i, j);
                    }
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            int find = find(root[i]);
            set.add(find);
        }
        
        return set.size();
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) root[b] = a;
    }
    
    private int find(int a) {
        if(a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}