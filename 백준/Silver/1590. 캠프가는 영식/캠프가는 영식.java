import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static int N, T;
	static List<Integer> busList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 버스 대수
		T = Integer.parseInt(st.nextToken()); // 도착 시간
		
		busList = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 버스 시작 시간
			int I = Integer.parseInt(st.nextToken()); // 버스 시간 간격
			int C = Integer.parseInt(st.nextToken()); // 버스 대수
			
			for(int j=0; j<C; j++) {
				busList.add(S + I * j);
			}
		}
		
		Collections.sort(busList);
		
		if(busList.get(0) >= T) result = busList.get(0) - T;
		else if(busList.get(busList.size() - 1) < T) result = -1;
		else result = binarySearch();
		
		System.out.println(result);
	}

	private static int binarySearch() {
		int left = 0;
		int rigth = busList.size() - 1;
		int mid = (left + rigth) / 2;
		
		while(left < rigth) {
			mid = (left + rigth) / 2;
			
			if(busList.get(mid) < T) left = mid + 1;
			else if(busList.get(mid) > T) rigth = mid;
			else return 0;
		}
		
		return busList.get(rigth) - T;
	}
}
