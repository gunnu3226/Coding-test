import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];

            for(int i=0; i<N; i++) {
                for(int j=1; j <= M; j++) {
                    if (j - coins[i] > 0) {
                        dp[j] += dp[j-coins[i]];
                    } else if (j - coins[i] == 0) dp[j]++;
                }
            }
            System.out.println(dp[M]);
        }
    }
}
