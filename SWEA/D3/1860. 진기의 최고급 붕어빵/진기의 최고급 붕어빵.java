
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int[] sum;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int[] people = new int[N];
            int pesum = 0;

            for (int i = 0; i < N; i++) {
                people[i] = sc.nextInt();
            }

            if(판독기(people,M,K)){
                System.out.println("#"+test_case+" Possible");
            } else {
                System.out.println("#"+test_case+" Impossible");
            }
        }
    }

    public static boolean 판독기(int[] sum, int M, int K) {
        Arrays.sort(sum);
        for(int i=0; i<sum.length; i++) {
            if(sum[i]/M*K-i<=0) {
                return false;
            }
        }
        return true;
    }

}