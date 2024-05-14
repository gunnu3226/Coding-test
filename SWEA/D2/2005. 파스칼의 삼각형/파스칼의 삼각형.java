import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            System.out.println("#"+tc);
            pascal(n);
        }
    }

    public static void pascal(int n) {
        int col = 2;
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<col; j++) {
                if(j == 0) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
            col++;
        }

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<=i; j++) {
                sb.append(arr[i][j] + " ");
            }
            System.out.println(sb);
        }
    }
}