
import java.util.Scanner;

class Solution {
    static int N, length;
    static int[] arr, lis;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            length = 0;
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            lis = new int[N];
            for (int i = 0; i < N; i++) {
                lis[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (lis[i] > length) {
                    length = lis[i];
                }
            }
            System.out.println("#" + test_case + " " + length);
        }
    }
}