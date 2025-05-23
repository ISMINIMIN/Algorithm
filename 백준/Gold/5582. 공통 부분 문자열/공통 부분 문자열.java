import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S1 = br.readLine();
        String S2 = br.readLine();

        int max = 0;
        int[][] dp = new int[S1.length() + 1][S2.length() + 1];

        for (int i = 1; i <= S1.length(); i++) {
            for (int j = 1; j <= S2.length(); j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
