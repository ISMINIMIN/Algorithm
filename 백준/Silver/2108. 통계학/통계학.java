import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int cnt = 0;
		int often = 0;
		
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			nums[i] = temp;
			map.put(temp, map.getOrDefault(temp, 0) + 1);
			cnt = Math.max(cnt, map.get(temp));
			sum += temp;
			max = Math.max(max, temp);
			min = Math.min(min, temp);
		}
		
		for(int key : map.keySet()) {
			if(map.get(key) == cnt) list.add(key);
		}
		
		Arrays.sort(nums);
		Collections.sort(list);
		
		if(list.size() == 1) often = list.get(0);
		else often = list.get(1);
		
		System.out.println(Math.round(sum / (nums.length * 1.0)));
		System.out.println(nums[nums.length / 2]);
		System.out.println(often);
		System.out.println(max - min);
	}
}
