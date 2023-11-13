
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Solution {
    static int[] arr;
    static HashSet<Integer> set;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            arr = new int[7];
            set = new HashSet<>();
            for(int i=0; i<7; i++) {
                arr[i] = sc.nextInt();
            }
            dp(0,0,0);

            Object[] sumarr = set.toArray();
            Arrays.sort(sumarr);

            System.out.println("#"+test_case+" "+sumarr[set.size()-5]);
        }
    }

    public static void dp(int depth, int index, int sum) {
        if(index == 7){
            if(depth == 3) {
                set.add(sum);
                return;
            }
            return;
        }
        dp(depth , index + 1, sum);
        dp(depth + 1, index + 1, sum + arr[index]);
    }
}