import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc < T; tc++) {

            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n+3];
            dp[0] = 1;
            for(int i=0; i<n; i++) {
                dp[i+1] = dp[i] + dp[i+1];
                dp[i+2] = dp[i] + dp[i+2];
                dp[i+3] = dp[i] + dp[i+3];
            }
            System.out.println(dp[n]);
        }
    }
}
