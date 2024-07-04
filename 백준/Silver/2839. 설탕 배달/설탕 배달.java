import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		
		while(N != 0) {
			if(N % 5 == 0) {
				count += N / 5;
				break;
			} else if(N < 0) {
				count = 0;
				break;
			}
			
			N -= 3;
			count++;
		}
		
		if(count == 0) System.out.println(-1);
		else System.out.println(count);
	}
}