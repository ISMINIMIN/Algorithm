import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] nums = line.substring(1, line.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') isReversed = !isReversed;
                else if (command == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReversed) deque.removeLast();
                    else deque.removeFirst();
                }
            }

            if (isError) System.out.println("error");
            else printDeque(deque, isReversed);
        }
    }

    private static void printDeque(Deque<Integer> deque, boolean isReversed) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (!deque.isEmpty()) {
            Iterator<Integer> it;

            if (isReversed) it = deque.descendingIterator();
            else it = deque.iterator();

            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) sb.append(",");
            }
        }

        sb.append("]");
        System.out.println(sb);
    }
}
