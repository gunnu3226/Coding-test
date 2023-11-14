
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Solution {
    static int N, sum, ans;
    static int[] arr;
    static boolean[] can;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            can = new boolean[sum + 10];
            can[0] = true;

            for (int i = 0; i < N; i++) {
                for (int j = sum; j >= 0; j--) {
                    if (can[j]) {
                        can[arr[i] + j] = true;
                    }
                }
            }
            ans = 0;
            for (int i = 0; i < can.length; i++) {
                if (can[i]) {
                    ans++;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}