import java.util.Scanner;

class Solution {

    static int n, k, count;
    static int[] arr;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            k = sc.nextInt();
            count = 0;
            arr= new int[n];

            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println("#"+tc+" "+count);
        }
    }

    public static void dfs(int start, int sum) {
        if (start >= n || sum >= k) {
            if (sum == k) {
                count++;
            }
            return;
        }
        dfs(start + 1, sum + arr[start]);
        dfs(start + 1, sum);
    }
}
