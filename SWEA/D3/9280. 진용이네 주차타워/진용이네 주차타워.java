import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[] park = new int[n];
            int[] moneys = new int[n];
            int[] weights = new int[m];
            int sum = 0;
            
            for(int i=0; i<n; i++) {
            	moneys[i] = Integer.parseInt(br.readLine());
            }
            
            for(int i=0; i<m; i++) {
            	weights[i] = Integer.parseInt(br.readLine());
            }
            
            Queue<Integer> parkQ = new LinkedList<Integer>();
            Queue<Integer> waitQ = new LinkedList<Integer>();
            
            for(int i=0; i<2*m; i++) {
            	parkQ.add(Integer.parseInt(br.readLine()));
            }
            
            while(!parkQ.isEmpty()) {
            	int car = parkQ.poll();
            	if(car > 0) {
            		waitQ.add(car);
            		for(int i=0; i<n; i++) {
            			if(park[i] == 0) {
            				park[i] = car;
            				waitQ.poll();
            				break;
            			}
            		}
            	} else {
            		for(int i=0; i<n; i++) {
            			if(park[i] == Math.abs(car)) {
            				sum += moneys[i] * weights[Math.abs(car)-1];
            				park[i] = 0;
            				if(!waitQ.isEmpty()) {
            					park[i] = waitQ.poll();
            				}
            				break;
            			}
            		}
            	}
            }
            
            System.out.println("#" + t + " " + sum);
		}
    }
}