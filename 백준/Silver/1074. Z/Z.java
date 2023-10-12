import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static int r, c;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		
		partition(0, 0, size);
	}

	private static void partition(int row, int col, int size) {
		if(row == r && col == c) {
			System.out.println(count);
			return;
		}
		
		if(r < row+size && c < col+size && r >= row && c >= col) {
			partition(row, col, size/2);
			partition(row, col+size/2, size/2);
			partition(row+size/2, col, size/2);
			partition(row+size/2, col+size/2, size/2);
		} else {
			count += size * size;
		}
	}
}