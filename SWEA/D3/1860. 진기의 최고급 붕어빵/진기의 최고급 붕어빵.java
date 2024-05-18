import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            boolean check = true;
            int[] time = new int[n];
            for(int i=0; i<n; i++) {
                time[i] = sc.nextInt();
            }
            Arrays.sort(time);

            for (int i=1; i<=n; i++) {
                if((time[i-1]/m)*k - i < 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("#"+tc+" Possible");
            } else {
                System.out.println("#"+tc+" Impossible");
            }
        }
    }
}
