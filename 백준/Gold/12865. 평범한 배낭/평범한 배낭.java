import java.io.*;
import java.util.*;

public class Main {

    static int n, k, max;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];

        for(int i=0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st2.nextToken());
            int value = Integer.parseInt(st2.nextToken());

            for(int j = k; weight <= j; j--) {
                dp[j] = Integer.max(dp[j], dp[j - weight] + value);
            }
        }
        System.out.println(dp[k]);
    }
}
