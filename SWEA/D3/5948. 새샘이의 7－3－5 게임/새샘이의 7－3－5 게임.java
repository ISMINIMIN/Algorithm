import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	int[] arr = new int[7];
        	Set<Integer> set = new HashSet<>();
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0; i<7; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	for(int i=0; i<arr.length-2; i++) {
        		for(int j=i+1; j<arr.length-1; j++) {
        			for(int k=j+1; k<arr.length; k++) {
        				int sum = arr[i] + arr[j] + arr[k];
        				set.add(sum);
        			}
        		}
        	}
        	
        	List<Integer> list = new LinkedList<>(set);
        	Collections.sort(list);
        	
        	System.out.println("#" + t + " " + list.get(list.size() - 5));
        }
    }
}