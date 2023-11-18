import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] player1, player2;
	static boolean[] numbers, visited;
	static int win, lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			player1 = new int[9];
			player2 = new int[9];
			visited = new boolean[9];
			numbers = new boolean[19];
			win = 0;
			lose = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				player1[i] = num;
				numbers[num] = true;
			}
			
			int idx = 0;
			for(int i=1; i<19; i++) {
				if(!numbers[i]) {
					player2[idx] = i;
					idx++;
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	private static void dfs(int depth, int sum1, int sum2) {
		if(depth == 9) {
			if(sum1 < sum2) lose++;
			if(sum1 > sum2) win++;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(player1[depth] > player2[i]) dfs(depth+1, sum1+player1[depth]+player2[i], sum2);
				if(player1[depth] < player2[i]) dfs(depth+1, sum1, sum2+player1[depth]+player2[i]);
				visited[i] = false;
			}
		}
	}
}