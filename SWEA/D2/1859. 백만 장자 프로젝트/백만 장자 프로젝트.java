
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int max = arr[arr.length - 1];
            Long diff = 0L;

            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i - 1] < max) {
                    diff += max - arr[i - 1];
                }
                if (arr[i - 1] > max) {
                    max = arr[i-1];
                }
            }
            System.out.println("#" + test_case + " " +diff);
        }
    }
}