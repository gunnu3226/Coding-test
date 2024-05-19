import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    static int n;
    static int[][] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();

        for (int tc = 1; tc <= 10; tc++) {
            n = sc.nextInt();
            arr = new int[n][n];

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            for(int j=0; j<n; j++) {
                int state = 0;
                for(int i=0; i<n; i++) {
                    if(state == 1 && arr[i][j] == 2) {
                        answer += 1;
                        state = arr[i][j];
                        continue;
                    }
                    if (arr[i][j] == 1 || arr[i][j] == 2) {
                        state = arr[i][j];
                    }
                }
            }
            System.out.println("#"+tc +" "+answer);
        }
    }
}
