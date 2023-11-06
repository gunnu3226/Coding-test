
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static List<String> code;
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            code = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                code.add(sc.next());
            }

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                String mode = sc.next();
                if(mode.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    insert(x,y);
                } else if (mode.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    delete(x,y);
                } else if (mode.equals("A")) {
                    int x = sc.nextInt();
                    plus(x);
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(code.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void insert(int x, int y){
        for (int j = 0; j < y; j++) {
            code.add(x + j, sc.next());
        }
    }

    public static void delete(int x, int y){
        for (int j = 0; j < y; j++) {
            code.remove(x);
        }
    }

    public static void plus(int x){
        for (int j = 0; j < x; j++) {
            code.add(sc.next());
        }
    }
}