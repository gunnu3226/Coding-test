
import java.util.Scanner;

class Solution {
    static int[] number;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int tc = sc.nextInt();
            number = new int[101];

            for(int i=0; i<1000; i++) {
                int score = sc.nextInt();
                number[score]++;
            }
            
            int max = 0;
            int ans = 0;
            for(int i=0; i<number.length; i++) {
                if(number[i]>=max){
                    max = number[i];
                    ans = i;
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}