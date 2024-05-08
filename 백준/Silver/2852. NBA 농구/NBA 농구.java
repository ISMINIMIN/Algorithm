import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int TEAM1 = 1;
	static final int TEAM2 = 2;
	static final String FINISH = "48:00";
	
	static StringBuilder sb;
	
	static class Info {
		int team;
		int time;
		int win;
		
		public Info(int team, int time) {
			this.team = team;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Info[] infos = new Info[N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			int time = stringToInt(st.nextToken());
			
			infos[i] = new Info(team, time);
		}
		
		infos[N] = new Info(0, stringToInt(FINISH));
		
		Info team1 = new Info(0, 0);
		Info team2 = new Info(0, 0);
		
		for(int i=0; i<N; i++) {
			if(infos[i].team == TEAM1) team1.team++;
			else team2.team++;
			
			if(team1.team == team2.team) continue;
			
			if(team1.team > team2.team) team1.time += infos[i+1].time - infos[i].time;
			else team2.time += infos[i+1].time - infos[i].time;
		}
		
		intToString(team1.time);
		sb.append("\n");
		intToString(team2.time);
		
		System.out.println(sb.toString());
	}

	private static void intToString(int time) {
		int min = time / 60;
		int sec = time % 60;
		sb.append(String.format("%02d", min)).append(":").append(String.format("%02d", sec));
	}

	private static int stringToInt(String time) {
		String[] elements = time.split(":");
		return Integer.parseInt(elements[0]) * 60 + Integer.parseInt(elements[1]);
	}
}
