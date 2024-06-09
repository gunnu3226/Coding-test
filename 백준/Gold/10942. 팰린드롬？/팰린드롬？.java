import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for(int j=1; j<=i; j++) {
                if (i == j) dp[i][j] = 1;
                else if (i - j == 1) dp[j][i] = (arr[i] == arr[j]) ? 1 : 0;
                else {
                    dp[j][i] = (arr[i] == arr[j] && dp[j+1][i-1] == 1) ? 1 : 0;
                }
            }
        }

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            sb.append(dp[startIdx][endIdx]).append("\n");
        }
        System.out.println(sb);
    }
}
