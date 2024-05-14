import java.util.Scanner;

class Solution {

    static int[][] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            arr = new int[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#"+tc);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                //90도 회전
                for(int j=0; j<n; j++) {
                    sb.append(arr[n-1-j][i]);
                }
                sb.append(" ");
                //180도 회전
                for(int j=0; j<n; j++) {
                    sb.append(arr[n-1-i][n-1-j]);
                }
                sb.append(" ");
                //270도 회전
                for(int j=0; j<n; j++) {
                    sb.append(arr[j][n-1-i]);
                }
                if(i != n-1) {
                    sb.append("\n");    
                }
            }

            System.out.println(sb);
        }
    }
}