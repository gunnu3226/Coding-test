
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int ans = 0;
            
            for(int x=-n; x<=n; x++) {
                for(int y = -n; y<= n; y++){
                    if(x*x + y*y <= n*n) {
                        ans += 1;
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}