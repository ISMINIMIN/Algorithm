class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;;
        int maxY = 0;
        int maxX = 0;
        
        for(int i=0; i<wallpaper.length; i++) {
            String str = wallpaper[i];
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(c == '#') {
                    if(minY > i) minY = i;
                    if(minX > j) minX = j;
                    if(maxY < i) maxY = i;
                    if(maxX < j) maxX = j;
                } 
            }
        }
        
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;
        
        return answer;
    }
}