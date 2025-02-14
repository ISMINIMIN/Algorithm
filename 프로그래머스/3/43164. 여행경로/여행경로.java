import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        Map<String, Queue<String>> flights = new HashMap<>();

        for(String[] ticket : tickets) {
            String departure = ticket[0];
            String arrival = ticket[1];

            flights.putIfAbsent(departure, new PriorityQueue<>());
            flights.get(departure).add(arrival);
        }

        Stack<String> route = new Stack<>();
        route.push("ICN");

        while(!route.isEmpty()) {
            String now = route.peek();

            if(flights.containsKey(now) && !flights.get(now).isEmpty()) {
                route.push(flights.get(now).poll());
                continue;
            }
            
            answer.add(route.pop());
        }

        Collections.reverse(answer);
        return answer.toArray(String[]::new);
    }
}
