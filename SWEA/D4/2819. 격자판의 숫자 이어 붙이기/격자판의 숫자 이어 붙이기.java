
import java.util.HashSet;
import java.util.Scanner;

class Solution {

    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<String> hs;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            hs = new HashSet<>();
            map = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    move(i, j, 0, "" + map[i][j]);
                }
            }
            System.out.println("#"+test_case+" "+hs.size());
        }
    }

    public static void move(int x, int y, int depth, String str) {
        if (depth == 6) {
            hs.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (0 <= cx && cx < 4 && 0 <= cy && cy < 4) {
                move(cx, cy, depth + 1, str + map[cx][cy]);
            }
        }
    }
}