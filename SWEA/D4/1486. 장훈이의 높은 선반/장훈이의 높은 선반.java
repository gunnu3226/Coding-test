import java.util.Scanner;

class Solution {
    static int N, B, min, diff;
    static int[] height;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            B = sc.nextInt();
            min = 0;
            diff = Integer.MAX_VALUE;
            height = new int[N];
            for(int i = 0; i<N; i++) {
                height[i] = sc.nextInt();
            }
            top(0, 0);
            System.out.println("#"+test_case+" "+diff);
        }

    }
    public static void top(int idx, int sum) {
        if(idx == N) {
            if(sum >= B && sum-B < diff) {
                diff = sum - B;
                return;
            } return;
        }
        top(idx + 1, sum + height[idx]);
        top(idx + 1, sum);
    }
}