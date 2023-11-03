
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int answer = 0;
            String[][] arr = new String[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.next();
                }
            }

            for (int j = 0; j < N; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (arr[i][j].equals("1") || arr[i][j].equals("2")) {
                        sb.append(arr[i][j]);
                    }
                }
                String str = sb.toString();
                String str2 = str.replaceAll("12", "");
                answer += (str.length() - str2.length()) / 2;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}