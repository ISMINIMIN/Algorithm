import java.util.Scanner;

public class S17319 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			if(N%2 != 0) {
				System.out.println("#" + i + " " + "No");
			} else {
				String front = str.substring(0, N/2);
				String back = str.substring(N/2);
				if(front.equals(back)) {
					System.out.println("#" + i + " " + "Yes");
				} else {
					System.out.println("#" + i + " " + "No");
				}
			}
		}
	}
}
