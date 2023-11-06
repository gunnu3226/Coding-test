
import java.util.Scanner;

class Solution {
    static int max;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            max = -1;

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int multi = arr[i] * arr[j];
                    increase(multi);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void increase(int num) {
        boolean up = true;
        String str = Integer.toString(num);

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) - '0' > str.charAt(i + 1) - '0') {
                up = false;
                break;
            }
        }
        if (up) {
            max = Math.max(num, max);
        }
    }
}