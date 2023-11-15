
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int N, min;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static String[][] arr;
    static int[][] countmine;
    static Queue<Point> q;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new String[N][N];
            countmine = new int[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.next().split("");
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    countMine(i, j);
                }
            }

            min = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (countmine[i][j] == 0 && !arr[i][j].equals("*")) {
                        click(i, j);
                        min++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (countmine[i][j] > 0 && !arr[i][j].equals("*")) {
                        min++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + min);
        }
    }

    public static void countMine(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int cntx = x + dx[i];
            int cnty = y + dy[i];
            if (cntx >= 0 && cntx <= N - 1 && cnty >= 0 && cnty <= N - 1) {
                if (arr[cntx][cnty].equals("*")) {
                    count++;
                }
            }
        }
        countmine[x][y] = count;
    }

    public static void click(int x, int y) {
        q = new LinkedList<>();
        q.add(new Point(x, y));

        countmine[x][y] = -1;

        while (!q.isEmpty()) {

            Point now = q.poll();
            for (int i = 0; i < 8; i++) {
                int cntx = now.x + dx[i];
                int cnty = now.y + dy[i];
                if (cntx < 0 || cntx > N - 1 || cnty < 0 || cnty > N - 1 || arr[cntx][cnty].equals("*")) {
                    continue;
                }
                if (countmine[cntx][cnty] == 0) {
                    q.add(new Point(cntx, cnty));
                }
                countmine[cntx][cnty] = -1;
            }
        }
    }
}