import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String word = br.readLine();
            sb.append(check(word)).append("\n");
        }

        System.out.print(sb);
    }

    private static int check(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(word, left + 1, right) || isPalindrome(word, left, right - 1)) return 1;
                else return 2;
            }
        }

        return 0;
    }

    private static boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) return false;
        }

        return true;
    }
}
