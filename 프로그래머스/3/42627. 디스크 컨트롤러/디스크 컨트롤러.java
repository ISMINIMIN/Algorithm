import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int clear = 0;
        int index = 0;
        int endTime = 0;
        int result = 0;
        
        while (clear < jobs.length) {
			while (index < jobs.length && jobs[index][0] <= endTime) {
				queue.add(jobs[index++]);
			}

			if (queue.isEmpty()) {
				endTime = jobs[index][0];
            }
            
            else {
				int[] job = queue.poll();
                endTime += job[1];
				result += (endTime - job[0]);
				clear++;
			}
		}
        
        return result / jobs.length;
    }
}