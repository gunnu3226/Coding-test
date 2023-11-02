
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String memory = sc.next();
            System.out.println("#"+test_case+" "+개수세기(memory));
        }
    }

    public static int 개수세기(String str) {
        char start = '0';
        int num = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)!= start) {
                num++;
                start = str.charAt(i);
            }
        }
        return num;
    }
}