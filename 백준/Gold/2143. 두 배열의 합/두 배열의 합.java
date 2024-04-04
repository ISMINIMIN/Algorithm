import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] arrB = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=i; j<N; j++) {
				sum += arrA[j];
				A.add(sum);
			}
		}
		
		for(int i=0; i<M; i++) {
			int sum = 0;
			for(int j=i; j<M; j++) {
				sum += arrB[j];
				B.add(sum);
			}
		}
		
		Collections.sort(A);
		Collections.sort(B);
		
		long result = 0;
		int left = 0;
		int right = B.size() - 1;
		
		while(left < A.size() && right >= 0) {
			int sum = A.get(left) + B.get(right);
			
			if(sum < T) left++;
			else if(sum > T) right--;
			else {
				int tempA = A.get(left);
				int tempB = B.get(right);
				long cntA = 0;
				long cntB = 0;
				
				while(left < A.size() && A.get(left) == tempA) {
					left++;
					cntA++;
				}
				
				while(right >= 0 && B.get(right) == tempB) {
					right--;
					cntB++;
				}
				
				result += cntA * cntB;
			}
		}
		
		System.out.println(result);
	}
}
