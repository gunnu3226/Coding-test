import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];

        for(int i=1; i<=n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i=3; i<=n; i++) {
            for(int j=2; j<=(i+1)/2; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
            }
        }

        int answer = (dp[n-1][k] + dp[n-3][k-1]) % MOD;
        System.out.println(answer);
    }
}
