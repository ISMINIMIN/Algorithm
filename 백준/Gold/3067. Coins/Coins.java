import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] coins, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            dp();
            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dp() {
        dp = new int[10001];
        dp[0] = 1;

        for(int i=0; i<N; i++) {
            for(int j=coins[i]; j<=M; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
    }
}
