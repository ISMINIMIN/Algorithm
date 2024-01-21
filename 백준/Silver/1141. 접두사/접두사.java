import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
		
		HashSet<String> set = new HashSet<>();
		for(String word : words) {
			boolean check = true;
			
			if(!set.isEmpty()) {
				for(String str : set) {
					if(str.indexOf(word) == 0) {
						check = false;
						break;
					}
				}
			}
			
			if(check) set.add(word);
		}
		
		System.out.println(set.size());
	}
}
