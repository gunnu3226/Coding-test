
import java.util.Scanner;

class Solution {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];
            arr[0][0] = 1;
            game(0, 0, 2);
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void game(int x, int y, int n) {
        if (n > N * N) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            while (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N
                    && arr[x + dx[i]][y + dy[i]] == 0) {
                x += dx[i];
                y += dy[i];
                arr[x][y] = n++;
            }
        }
        game(x, y, n);
    }
}
