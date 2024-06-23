import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int length = 0;
        int max_idx = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if (arr[j] < num) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            if(length < dp[i]) {
                length = dp[i];
                max_idx = i;
            }
        }
        sb.append(length).append("\n");

        for(int i=max_idx; i >= 0; i--) {
            if (length == dp[i]) {
                stack.add(arr[i]);
                length--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
