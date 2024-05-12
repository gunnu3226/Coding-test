import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            double average = sum / n;
            int answer = 0;
            for (int i=0; i<n; i++) {
                if (arr[i] <= average) {
                    answer++;
                }
            }
            System.out.println("#"+tc+" "+answer);
        }
    }
}