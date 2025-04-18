class Solution {
    public int solution(int[] a) {
        int len = a.length;
        if (len == 1) return 1;
        
        int answer = 2; // 풍선이 두 개 이상일 때, 양쪽 끝 풍선은 항상 터지지 않음
        
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];
        
        leftMin[0] = a[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i - 1]);
        }
        
        rightMin[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i + 1]);
        }
        
        for (int i = 1; i < len - 1; i++) {
            if (a[i] < leftMin[i] || a[i] < rightMin[i]) answer++;
        }
        
        return answer;
    }
}