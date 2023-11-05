
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int answer;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            answer = 거듭제곱(N,M);

            System.out.println("#"+T+" "+answer);
        }
    }

    public static int 거듭제곱(int N, int M) {
        if(M == 0) {
            return 1;
        }
        return N * 거듭제곱(N,M-1);
    }
}