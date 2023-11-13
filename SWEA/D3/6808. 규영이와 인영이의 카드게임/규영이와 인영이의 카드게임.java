
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static int userwin, comwin, usersum, comsum;
    static int[] userarr;
    static int[] comarr;

    static int[] result;
    static boolean[] check;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            userarr = new int[9];
            comarr = new int[9];
            userwin = 0;
            comwin = 0;

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1; i<=18; i++) {
                list.add(i);
            }
            for(int i=0;i<9;i++) {
                int n = sc.nextInt();
                userarr[i] = n;
                list.remove(Integer.valueOf(n));
            }
            for(int i=0; i<9; i++){
                comarr[i] = list.get(i);
            }

            result = new int[9];
            check = new boolean[9];
            permutation(0);

            System.out.println("#"+test_case+" "+userwin+" "+comwin);
        }
    }

    public static void permutation(int round) {
        if(round == 9) {
            usersum = 0;
            comsum = 0;

            for(int i=0; i<9; i++){
                if(userarr[i]>result[i]) {
                    usersum += userarr[i] + result[i];
                } else {
                    comsum += userarr[i] + result[i];
                }
            }

            if(usersum > comsum) {
                userwin++;
            }else if(usersum < comsum) {
                comwin++;
            }
        }

        for(int i=0; i<9; i++) {
            if(!check[i]) {
                result[round] = comarr[i];
                check[i] = true;
                permutation(round+1);
                check[i] = false;
            }
        }
    }
}