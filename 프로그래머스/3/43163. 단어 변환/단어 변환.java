class Solution {
    boolean[] visited;
    int result = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    
    private void dfs(String str, String target, String[] words, int depth) {
        if(str.equals(target)) {
            result = Math.min(result, depth);
            return;
        }
        
        if(depth == words.length) {
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            int count = 0;
            for(int j=0; j<word.length(); j++) {
                if(str.charAt(j) != word.charAt(j)) count++;
            }
            
            if(count == 1) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(word, target, words, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}