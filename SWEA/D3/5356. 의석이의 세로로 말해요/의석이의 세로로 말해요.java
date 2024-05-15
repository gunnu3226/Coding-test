import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String[][] arr = new String[5][15];
            for(int i=0; i<5; i++) {
                String[] split = sc.next().split("");
                for(int j=0; j< split.length; j++) {
                    arr[i][j] = split[j];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<15; i++) {
                for(int j=0; j<5; j++) {
                    if(arr[j][i] != null) {
                        sb.append(arr[j][i]);
                    }
                }
            }
            System.out.println("#"+tc+" "+sb);
        }
    }
}