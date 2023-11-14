
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int[][] maze;
    static Queue<Pair> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int t = sc.nextInt();
            maze = new int[16][16];
            q = new LinkedList<>();

            for (int i = 0; i < 16; i++) {
                String[] row = sc.next().split("");
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = Integer.parseInt(row[j]);
                }
            }
            System.out.println("#" + test_case + " " + game(1, 1));
        }
    }

    public static int game(int x, int y) {
        q.offer(new Pair(x, y));
        maze[x][y] = 1;

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int i = 0; i < 4; i++) {
                int curx = pair.x + dx[i];
                int cury = pair.y + dy[i];

                if (rangeCheck(curx, cury) && maze[curx][cury] == 0) {
                    q.offer(new Pair(curx, cury));
                    maze[curx][cury] = 1;
                }

                if (rangeCheck(curx, cury) && maze[curx][cury] == 3) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static boolean rangeCheck(int x, int y) {
        if (x >= 0 && x < 16 && y >= 0 && y < 16) {
            return true;
        } else {
            return false;
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}