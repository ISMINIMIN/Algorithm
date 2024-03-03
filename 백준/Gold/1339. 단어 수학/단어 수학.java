import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static int result = 0;
	static ArrayList<String> nums;
	static ArrayList<ArrayList<Character>> list;
	static HashMap<Character, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			int len = line.length() - 1;
			for(int j=0; j<=len; j++) {
				char temp = line.charAt(j);
				arr[temp - 'A'] += Math.pow(10, len - j);
			}
		}
		
		Arrays.sort(arr);
		
		int num = 9;
		int idx = 25;
		int result = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[idx] == 0) continue;
			result += arr[idx] * num;
			num--;
			idx--;
		}
		
		System.out.println(result);
	}
}
