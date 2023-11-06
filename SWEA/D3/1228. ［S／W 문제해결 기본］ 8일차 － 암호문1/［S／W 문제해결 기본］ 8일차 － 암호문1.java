
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            List<String> code = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                code.add(sc.next());
            }

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                String I = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();

                for (int j = 0; j < y; j++) {
                    code.add(x + j, sc.next());
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(code.get(i) + " ");
            }
            System.out.println();
        }
    }
}