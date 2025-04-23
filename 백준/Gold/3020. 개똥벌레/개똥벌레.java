import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] sum = new int[H + 2];

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                sum[1]++;
                sum[height + 1]--;
            } else {
                int start = H - height + 1;
                sum[start]++;
                sum[H + 1]--;
            }
        }

        for (int i = 1; i <= H; i++) {
            sum[i] += sum[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            if (sum[i] < min) {
                min = sum[i];
                cnt = 1;
            } else if (sum[i] == min) {
                cnt ++;
            }
        }

        sb.append(min).append(" ").append(cnt);

        System.out.println(sb);
    }
}
