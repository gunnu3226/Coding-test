import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] memory;
    static int[] cost;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        memory = new int[n];
        cost = new int[n];
        dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=10000; i++) {
            dp[i] = -1;
        }

        for(int i=0; i<n; i++) {
            int cur = cost[i];

            for(int j=10000; j>=cur; j--) {
                if (dp[j-cur] != -1) {
                    dp[j] = Math.max(dp[j], dp[j-cur] +  memory[i]);
                }
            }
            dp[cur] = Math.max(dp[cur], memory[i]);
        }
        for(int i=0; i<= 10000; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
