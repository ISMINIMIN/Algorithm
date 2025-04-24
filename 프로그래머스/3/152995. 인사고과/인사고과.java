import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int peerMax = 0;
        int targetSum = target[0] + target[1];
        boolean isTargetDropped = false;

        List<Integer> scoreSums = new ArrayList<>();
        for (int[] score : scores) {
            if (score[1] < peerMax) {
                if (score == target) isTargetDropped = true;
                continue;
            }

            peerMax = Math.max(peerMax, score[1]);
            scoreSums.add(score[0] + score[1]);
        }

        if (isTargetDropped) return -1;

        int rank = 1;
        for (int sum : scoreSums) {
            if (sum > targetSum) rank++;
        }

        return rank;
    }
}