import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        int count = 0;
        while(dp[1] == INF) {
            dp(count++, n, dp);
        }
        System.out.println(dp[1]);
    }

    public static void dp(int count, int n, int[] dp) {
        for(int i = n; i > 0; i--) {
            if (dp[i] == count) {
                if (i % 2 == 0 && dp[i / 2] == INF) dp[i / 2] = count + 1;

                if (i % 3 == 0 && dp[i /3] == INF) dp[i / 3] = count + 1;

                if (dp[i - 1] == INF) dp[i - 1] = count + 1;
            }
        }
    }
}
