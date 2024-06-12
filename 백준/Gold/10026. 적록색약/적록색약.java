import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, normal, abnormal;
    static char[][] map;
    static int[][] check;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i=0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        normal = 0;
        check = new int[n][map[0].length];
        for(int i=0; i<n; i++) {
            for(int j=0; j<map[i].length; j++) {
                if (check[i][j] == 0) {
                    normalBfs(new Point(i,j));
                    normal++;
                }
            }
        }

        abnormal = 0;
        check = new int[n][map[0].length];
        for(int i=0; i<n; i++) {
            for(int j=0; j<map[i].length; j++) {
                if (check[i][j] == 0) {
                    if (map[i][j] == 'B') {
                        normalBfs(new Point(i,j));
                    } else {
                        abnormalBfs(new Point(i,j));
                    }
                    abnormal++;
                }
            }
        }
        System.out.println(normal + " " + abnormal);
    }

    public static void normalBfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        check[point.row][point.col] = 1;

        while (!q.isEmpty()) {
            Point cnt = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = cnt.row + di[i];
                int col = cnt.col + dj[i];

                if (row < 0 || row >= n || col < 0 || col >= map[0].length) continue;

                if (check[row][col] == 0 && map[row][col] == map[point.row][point.col]) {
                    q.add(new Point(row, col));
                    check[row][col] = 1;
                }
            }
        }
    }

    public static void abnormalBfs(Point point){
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        check[point.row][point.col] = 1;

        while (!q.isEmpty()) {
            Point cnt = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = cnt.row + di[i];
                int col = cnt.col + dj[i];

                if (row < 0 || row >= n || col < 0 || col >= map[0].length)
                    continue;

                if (check[row][col] == 0) {
                    if (map[row][col] == 'R' || map[row][col] == 'G') {
                        q.add(new Point(row, col));
                        check[row][col] = 1;
                    }
                }
            }
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
