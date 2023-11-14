
import java.util.Scanner;

class Solution {
    static int N, M, max;
    static int[][] arr;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N][N];
            max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int cnt = mplus(i, j);
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static int mplus(int x, int y) {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sum += arr[x + i][y + j];
            }
        }
        return sum;
    }
}