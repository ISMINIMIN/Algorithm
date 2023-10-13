import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		int count = 0;
		String IOI = "I";
		for(int i=0; i<N; i++) {
			IOI += "OI";
		}
		
		for(int i=0; i<M-IOI.length()+1; i++) {
			if(line.substring(i, i+IOI.length()).equals(IOI)) count++;
		}
		
		System.out.println(count);
	}
}