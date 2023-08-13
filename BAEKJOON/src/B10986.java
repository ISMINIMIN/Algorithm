import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 주어지는 숫자 개수
		int M = Integer.parseInt(st.nextToken()); // 나누는 수
		
		// 입력 조건을 고려하여 sum 배열과 remainderCount 배열, result는 long형으로 선언
		long[] sum = new long[N+1]; // 구간 합 배열
		long[] remainderCount = new long[M]; // 나머지 카운트 배열(M으로 나누는 경우 나올 수 있는 나머지는 0~M-1이므로 인덱스를 나머지로 취급)
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken()); // 입력받은 숫자를 이전 합에 더해 구간 합 배열에 저장
			remainderCount[(int)(sum[i]%M)]++; // 현재까지의 합을 M으로 나눈 나머지의 인덱스를 증가시켜 나머지 개수 파악
		}
		
		long result = remainderCount[0]; // 나머지가 0인 경우 해당 구간의 합은 M으로 나누어 떨어진다는 의미이므로 result 변수에 저장
		for(int i=0; i<M; i++) {
			if(remainderCount[i] > 1) { // 나머지 개수가 2개 이상인 구간의 경우
				result += (remainderCount[i] * (remainderCount[i]-1)) / 2; // 나머지가 같은 구간 중 2개를 뽑는 경우의 수를 result에 더하기
			}
		}
		
		System.out.println(result); // 정답 출력
	}
}