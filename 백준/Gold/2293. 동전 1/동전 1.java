import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++) {
            for(int j=1; j <= k; j++) {
                if (j - coins[i] > 0) {
                    dp[j] += dp[j-coins[i]];
                } else if (j - coins[i] == 0) dp[j]++;
            }
        }
        System.out.println(dp[k]);
    }
}
