import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int newScore = sc.nextInt();
        int P = sc.nextInt();

        Integer[] scores = new Integer[N];
        for(int i=0; i<N; i++){
        	scores[i] = sc.nextInt();
        }
        
        Arrays.sort(scores, Collections.reverseOrder());

        if(N == P && newScore <= scores[scores.length-1]) {
        	System.out.print(-1);
        } else {
            int rank = 1;
            
            for(int i=0; i<scores.length; i++){
                if(newScore < scores[i]) rank++;
                else break;
            }
            
            System.out.print(rank);
        }
	}
}