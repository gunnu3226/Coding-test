import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int i, j, move;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Point(int i, int j, int move) {
            this.i = i;
            this.j = j;
            this.move = move;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int h, w, answer, dust_idx;
    static int[][] distance;
    static char[][] map;
    static Point[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            if (w == 0 && h == 0) break;

            map = new char[h][w];
            list = new Point[11];

            dust_idx = 1;

            for(int i=0; i < h; i++) {
                String line = br.readLine();
                for(int j=0; j < w; j++) {
                    map[i][j] = line.charAt(j);

                    if (map[i][j] == 'o') list[0] = new Point(i, j);
                    else if (map[i][j] == '*') list[dust_idx++] = new Point(i,j);
                }
            }

            answer = Integer.MAX_VALUE;
            distance = new int[dust_idx+1][dust_idx+1];

            for(int i = 0; i<dust_idx; i++) {
                for(int j = i + 1; j < dust_idx; j++) {
                    int res = bfs(list[i], list[j]);
                    if (res == -1) {
                        answer = -1;
                    } else {
                        distance[i][j] = distance[j][i] = res;
                    }
                }
            }
            boolean[] selected = new boolean[dust_idx];
            permutation(0, 0, 0, selected);
            System.out.println(answer);
        }
    }

    static void permutation(int idx, int cnt, int sum, boolean[] selected) {
        if (cnt == dust_idx - 1) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int i=1; i < dust_idx; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            permutation(i, cnt + 1, sum + distance[idx][i], selected);
            selected[i] = false;
        }
    }

    static int bfs(Point start, Point end) {
        boolean[][] visited = new boolean[h][w];
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.i][start.j] = true;
        map[start.i][start.j] = '.';

        while(!q.isEmpty()) {
            Point point = q.poll();

            if (point.i == end.i && point.j == end.j) {
                return point.move;
            }

            for(int i=0; i<4; i++) {
                int ni = point.i + dx[i];
                int nj = point.j + dy[i];
                if (ni < 0 || ni >= h || nj < 0 || nj >= w) continue;
                if (visited[ni][nj] || map[ni][nj] == 'x') continue;
                q.offer(new Point(ni, nj, point.move + 1));
                visited[ni][nj] = true;
            }
        }
        return -1;
    }
}
