import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        int[] dp = new int[k+1];
        Arrays.fill(dp, k+1);

        for(int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= k) dp[coins[i]] = 1;
        }

        for(int i = 0; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if (dp[k] == k+1) {
            System.out.println("-1");
            return;
        }
        System.out.println(dp[k]);
    }
}
