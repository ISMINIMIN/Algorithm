import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> queue = convertToTimeInt(timetable);
        int answer = getBus(n, t, m, queue);
        return convertToTimeString(answer);
    }
    
    private int getBus(int n, int t, int m, PriorityQueue<Integer> queue) {
        int busTime = 540;
        int lastCount = 0;
        int lastCrewTime = 0;
        
        for(int i=0; i<n; i++) {
            int count = 0;
            int crewTime = 0;
            
            while(count < m && !queue.isEmpty() && queue.peek() <= busTime) {
                crewTime = queue.poll();
                count++;
            }
            
            if(i == n - 1) {
                lastCount = count;
                lastCrewTime = crewTime;
            }
            
            if(i < n - 1) busTime += t;
        }
        
        if(lastCount == m) return lastCrewTime - 1;
        return busTime;
    }
    
    private PriorityQueue<Integer> convertToTimeInt(String[] timetable) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(String time : timetable) {
            String[] times = time.split(":");
            int minute = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            queue.add(minute);
        }
        
        return queue;
    }
    
    private String convertToTimeString(int time) {
        int hour = time / 60;
        int minute = time % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}