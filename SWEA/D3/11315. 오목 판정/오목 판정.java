
import java.util.Scanner;

class Solution {
    static int N;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            String[][] arr = new String[N][N];

            for(int i =0; i<N; i++) {
                arr[i] = sc.next().split("");
            }

            if (check(arr)) {
                System.out.println("#" + test_case + " " + "YES");
            } else {
                System.out.println("#" + test_case + " " + "NO");
            }
        }
    }

    public static boolean check(String[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j].equals("o")){
                    if (i <= N - 5) {
                        if (rowcheck(i, j, arr)) {
                            return true;
                        }
                    }
                    if (j <= N - 5) {
                        if (colcheck(i, j, arr)) {
                            return true;
                        }
                    }
                    if (i <= N - 5 && j <= N - 5) {
                        if (diaright(i, j, arr)) {
                            return true;
                        }
                    }
                    if (i >= 4 && j <= N - 5) {
                        if (dialeft(i, j, arr)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean rowcheck(int x, int y, String[][] arr) {
        for (int i = 0; i < 5; i++) {
            if (!arr[x + i][y].equals("o")) {
                return false;
            }
        }
        return true;
    }

    public static boolean colcheck(int x, int y, String[][] arr) {
        for (int i = 0; i < 5; i++) {
            if (!arr[x][y + i].equals("o")) {
                return false;
            }
        }
        return true;
    }

    public static boolean dialeft(int x, int y, String[][] arr) {
        for (int i = 0; i < 5; i++) {
            if (!arr[x - i][y + i].equals("o")) {
                return false;
            }
        }
        return true;
    }

    public static boolean diaright(int x, int y, String[][] arr) {
        for (int i = 0; i < 5; i++) {
            if (!arr[x + i][y + i].equals("o")) {
                return false;
            }
        }
        return true;
    }
}