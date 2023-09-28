import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<number.length(); i++) {
			int num = number.charAt(i)-'0';
			
			if(num == 9) {
				map.put(6, map.getOrDefault(6, 0) + 1);
				continue;
			}
			
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int max = 0;
		
		for(int i : map.keySet()) {
			int current =  map.get(i);
			
			if(i == 6) {
				if(current % 2 == 0) current = current / 2;
				else current = current / 2 + 1;
			}
			
			if(max < current) {
				max = current;
			}
		}
		
		System.out.println(max);
	}
}