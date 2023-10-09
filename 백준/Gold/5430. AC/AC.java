import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String pLine = br.readLine();
			
			boolean reverse = false;
			boolean error = false;
			
			char[] p = new char[pLine.length()];
			for(int i=0; i<p.length; i++) {
				p[i] = pLine.charAt(i);
			}
			
			int n = Integer.parseInt(br.readLine());
			String[] num = new String[n];
			String nLine = br.readLine();
			nLine = nLine.replace("[", "").replace("]", "");
			
			num = nLine.split(",");
			Deque<Integer> queue = new LinkedList<>();
			
			for(int i=0; i<n; i++) {
				queue.add(Integer.parseInt(num[i]));
			}
			
			for(int i=0; i<p.length; i++) {
				if(p[i] == 'D') {
					if(queue.isEmpty()) {
						sb.append("error\n");
						error = true;
						break;
					}
					
					if(reverse) queue.removeLast();
					else queue.removeFirst();
				} else {
					reverse = !reverse;
				}
			}
			
			if(!error) {
				if(reverse) {
					sb.append("[");
					while (!queue.isEmpty()) {
						sb.append(queue.removeLast());
						if (!queue.isEmpty()) {
							sb.append(",");
						}
					}
					sb.append("]\n");
				} else {
					sb.append("[");
					while (!queue.isEmpty()) {
						sb.append(queue.removeFirst());
						if (!queue.isEmpty()) {
							sb.append(",");
						}
					}
					sb.append("]\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}