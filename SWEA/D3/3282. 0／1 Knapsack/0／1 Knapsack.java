import java.util.Scanner;

class Solution {
    static int N, K, maxC;
    static int[] arrV;
    static int[] arrC;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            maxC = 0;
            arrV = new int[N+1];
            arrC = new int[N+1];
            for (int i = 1; i <= N; i++) {
                arrV[i] = sc.nextInt();
                arrC[i] = sc.nextInt();
            }
            int dp[][] = new int[N+1][K+1];
            for(int i=1;i<=N;i++) {
                for(int j=1; j<=K; j++) {
                    if(arrV[i] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - arrV[i]] + arrC[i], dp[i - 1][j]);
                    }
                }
            }
            System.out.println("#" + test_case + " " + dp[N][K]);
        }
    }
}