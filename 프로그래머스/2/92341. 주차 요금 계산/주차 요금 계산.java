import java.util.*;

class Solution {
    Map<Integer, Integer> times = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> parking = new HashMap<>();
        
        for(String record : records) {
            String time = record.split(" ")[0];
            String number = record.split(" ")[1];
            String status = record.split(" ")[2];
            
            if(status.equals("IN")) parking.put(number, time);
            else {
                calMinutes(parking.get(number), time, number);
                parking.remove(number);
            }
        }
        
        for(String number : parking.keySet()) {
            calMinutes(parking.get(number), "23:59", number);
        }
        
        int[] answer = new int[times.size()];
        int idx = 0;
        for(Integer number : times.keySet()) {
            answer[idx] = calPayment(times.get(number), fees);
            idx++;
        }
        
        return answer;
    }
    
    private void calMinutes(String inTime, String outTime, String number) {
        String[] inTemp = inTime.split(":");
        String[] outTemp = outTime.split(":");
        int in = Integer.parseInt(inTemp[0]) * 60 + Integer.parseInt(inTemp[1]);
        int out = Integer.parseInt(outTemp[0]) * 60 + Integer.parseInt(outTemp[1]);
        int total = out - in;
        
        int carNumber = Integer.parseInt(number);
        if(times.containsKey(carNumber)) {
            times.put(carNumber, times.get(carNumber) + total);
        } else {
            times.put(carNumber, total);
        }
    }
    
    private int calPayment(int time, int[] fees) {
        int payment = fees[1];
        if(time > fees[0]) payment += Math.ceil((time - fees[0]) * 1.0 / fees[2]) * fees[3];
        return payment;
    }
}