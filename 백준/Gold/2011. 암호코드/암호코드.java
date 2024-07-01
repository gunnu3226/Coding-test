import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int length = input.length();

        if (input.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= length; i++) {
            int oneDigit = Integer.parseInt(input.substring(i - 1, i));
            int twoDigits = Integer.parseInt(input.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= 1000000; // 결과를 1,000,000으로 나눈 나머지를 저장
        }

        System.out.println(dp[length]);
    }
}
