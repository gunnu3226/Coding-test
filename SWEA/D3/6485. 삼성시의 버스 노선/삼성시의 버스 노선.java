import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[] count = new int[5001];
            int n = sc.nextInt();
            for(int i=0; i<n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                for(int j=start; j<=end; j++) {
                    count[j]++;
                }
            }
            StringBuilder sb = new StringBuilder();
            int p = sc.nextInt();
            for(int i=0; i<p; i++) {
                sb.append(count[sc.nextInt()]+" ");
            }
            System.out.println("#"+tc+" "+sb);
        }
    }
}