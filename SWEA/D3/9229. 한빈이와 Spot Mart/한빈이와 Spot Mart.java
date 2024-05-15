import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int best = -1;
            int n = sc.nextInt();
            int limit = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int start = 0;
            int end = n-1;
            
            while(start != end) {
                int sum = arr[start] + arr[end];
                
                if(sum > limit) end--;
                else {
                    best = Math.max(best, sum);
                    start++;
                }
            }
            System.out.println("#" + tc + " " + best);
        }
    }
}