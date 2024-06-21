import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n+2];
        int[] pay = new int[n+2];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+2];
        int max = 0;
        for(int i=1; i<=n+1; i++) {
            if (max < dp[i]) max = dp[i];
            int day = i + time[i];

            if (day <= n+1) {
                dp[day] = Math.max(dp[day], max + pay[i]);
            }
        }
        System.out.println(max);
    }
}
