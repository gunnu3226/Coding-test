import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, K;
    static int[] novelSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t<T; t++) {
            K = Integer.parseInt(br.readLine());
            novelSum = new int[K+1];
            dp = new int[K+1][K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i=1; i<=K; i++) {
                novelSum[i] = novelSum[i-1] + Integer.parseInt(st.nextToken());
            }
            sumFile();
            System.out.println(dp[1][K]);
        }
    }

    public static void sumFile() {
        for(int n=1; n<=K; n++) {
            for(int from = 1; from + n <= K; from++) {
                int to = from + n;
                dp[from][to] = Integer.MAX_VALUE;
                for(int mid = from; mid < to; mid++) {
                    dp[from][to] = Math.min(dp[from][to],
                        dp[from][mid] + dp[mid+1][to]
                            + novelSum[to] - novelSum[from - 1]);
                }
            }
        }
    }
}
