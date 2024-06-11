import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, n, m, k, answer;
    static int[][] map;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }

            answer = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if (map[i][j] == 1) {
                        bfs(new Point(i,j));
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        map[point.row][point.col] = -1;

        while(!q.isEmpty()) {
            Point cnt = q.poll();

            for (int i=0; i<4; i++) {
                int row = cnt.row + di[i];
                int col = cnt.col + dj[i];

                if (row < 0 || row >=n || col < 0 || col >= m) continue;

                if (map[row][col] == 1) {
                    q.add(new Point(row, col));
                    map[row][col] = -1;
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
