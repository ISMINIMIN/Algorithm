import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for(int i=0; i<N; i++) {
            int start = 0;
            int end = N-1;

            while(true) {
                if(i == start) start++;
                if(i == end) end--;
                if(start == end) break;

                if(nums[start] + nums[end] < nums[i]) start++;
                else if(nums[start] + nums[end] > nums[i]) end--;
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
