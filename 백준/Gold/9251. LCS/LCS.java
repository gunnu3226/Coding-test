import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int aLength = a.length();
        int bLength = b.length();

        char[] A = new char[aLength + 1];
        char[] B = new char[bLength + 1];

        for(int i=1; i<=aLength; i++) {
            A[i] = a.charAt(i-1);
        }
        for(int i=1; i<=bLength; i++) {
            B[i] = b.charAt(i-1);
        }

        int[][] dp = new int[aLength+1][bLength+1];

        for(int i=1; i<=aLength; i++) {
            for(int j=1; j<=bLength; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[aLength][bLength]);
    }
}
