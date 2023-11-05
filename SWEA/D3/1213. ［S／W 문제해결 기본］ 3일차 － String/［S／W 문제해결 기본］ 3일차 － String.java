
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            int answer = 0;
            String search = sc.next();
            String string = sc.next();

            String re = string.replaceAll(search, "");
            
            answer = (string.length()-re.length())/search.length();

            System.out.println("#"+T+" "+answer);
            
        }
    }

}