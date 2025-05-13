import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] P, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] deck = new int[N];
        int[] origin = new int[N];
        for (int i = 0; i < N; i++) {
            deck[i] = i;
            origin[i] = i;
        }

        int count = 0;
        while (true) {
            if (isCorrect(deck)) break;

            deck = shuffle(deck);
            count++;

            if (Arrays.equals(deck, origin)) {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }

    static boolean isCorrect(int[] deck) {
        for (int i = 0; i < N; i++) {
            if (P[deck[i]] != i % 3) return false;
        }

        return true;
    }

    private static int[] shuffle(int[] deck) {
        int[] newDeck = new int[N];

        for (int i = 0; i < N; i++) {
            newDeck[S[i]] = deck[i];
        }

        return newDeck;
    }
}
