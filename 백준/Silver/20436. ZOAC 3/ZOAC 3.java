import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int min;
	static String target;
	
	static Map<Character, Position> lKeys = new HashMap<>();
	static Map<Character, Position> rKeys = new HashMap<>();
	
	static class Position {
		int y;
		int x;
		
		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		
		String S = br.readLine();
		Position lHand = lKeys.get(S.charAt(0));
		Position rHand = rKeys.get(S.charAt(2));
		
		min = 0;
		target = br.readLine();
		
		for(int i=0; i<target.length(); i++) {
			char key = target.charAt(i);
			
			Position nHand;
			if(lKeys.containsKey(key)) {
				nHand = lKeys.get(key);
				min += Math.abs(lHand.x - nHand.x) + Math.abs(lHand.y - nHand.y);
				lHand = nHand;
			} else {
				nHand = rKeys.get(key);
				min += Math.abs(rHand.x - nHand.x) + Math.abs(rHand.y - nHand.y);
				rHand = nHand;
			}
			
			min += 1;
		}
		
		System.out.println(min);
	}

	private static void init() {
		lKeys.put('q',new Position(0,0));
		lKeys.put('w',new Position(0,1));
		lKeys.put('e',new Position(0,2));
		lKeys.put('r',new Position(0,3));
		lKeys.put('t',new Position(0,4));
		rKeys.put('y',new Position(0,5));
		rKeys.put('u',new Position(0,6));
		rKeys.put('i',new Position(0,7));
		rKeys.put('o',new Position(0,8));
		rKeys.put('p',new Position(0,9));
        
		lKeys.put('a',new Position(1,0));
		lKeys.put('s',new Position(1,1));
		lKeys.put('d',new Position(1,2));
		lKeys.put('f',new Position(1,3));
		lKeys.put('g',new Position(1,4));
		rKeys.put('h',new Position(1,5));
		rKeys.put('j',new Position(1,6));
		rKeys.put('k',new Position(1,7));
		rKeys.put('l',new Position(1,8));
        
        lKeys.put('z',new Position(2,0));
        lKeys.put('x',new Position(2,1));
        lKeys.put('c',new Position(2,2));
        lKeys.put('v',new Position(2,3));
        rKeys.put('b',new Position(2,4));
        rKeys.put('n',new Position(2,5));
        rKeys.put('m',new Position(2,6));
	}
}
