import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, (a, b) -> {
		    int len = Integer.compare(a.length(), b.length());
		    if (len != 0) {
		        return len;
		    } else {
		        return a.compareTo(b);
		    }
		});
		
		for(String str : list) {
			System.out.println(str);
		}
	}
}