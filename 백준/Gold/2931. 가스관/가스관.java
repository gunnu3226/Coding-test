import java.io.*;
import java.util.*;

public class Main {

    static class Point {

        int x, y, dir;

        public Point(int x, int y, int dir) {
            super();
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

    public static class MyScanner {

        BufferedReader bf;
        StringTokenizer st;

        MyScanner() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static int n, m;
    static char map[][];
    static final int dx[] = {-1, 1, 0, 0};
    static final int dy[] = {0, 0, -1, 1};

    public static int nextDir(int pdir, char c) { //블록의 다음 방향 return 해줌 -1이면 불가능한 경우임
        if (c == '1') {
            if (pdir == 0)
                return 3;
            if (pdir == 2)
                return 1;
        } else if (c == '2') {
            if (pdir == 1)
                return 3;
            if (pdir == 2)
                return 0;
        } else if (c == '3') {
            if (pdir == 3)
                return 0;
            if (pdir == 1)
                return 2;
        } else if (c == '4') {
            if (pdir == 3)
                return 1;
            if (pdir == 0)
                return 2;
        } else if (c == '-') {
            if (pdir == 3 || pdir == 2)
                return pdir;
        } else if (c == '|') {
            if (pdir == 0 || pdir == 1)
                return pdir;

        } else // + 블록
            return pdir;

        return -1;

    }

    static char block[] = new char[]{'1', '2', '3', '4', '-', '|', '+'};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyScanner sc = new MyScanner();

        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n + 1][m + 1];
        int blockcnt = 0; //블록의 개수 모든 블록을 다 사용했는지 체크하기 위함
        int sx = 0, sy = 0; //시작점
        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1);
                if (map[i][j] == 'M') {
                    sx = i;
                    sy = j;
                }
                if (map[i][j] == '1' || map[i][j] == '2' || map[i][j] == '3' || map[i][j] == '4'
                    || map[i][j] == '-'
                    || map[i][j] == '|' || map[i][j] == '+') {
                    blockcnt++;
                }
                if (map[i][j] == '+') // + 는 2번 방문하기때문에 블록 갯수에 2번 더해줌
                    blockcnt++;
            }
        }

        int sdir = 0;
        for (int i = 0; i < 4; i++) { //시작점에서 시작하는 방향 찾기
            if (sx + dx[i] > n || sy + dy[i] > m)
                continue;
            if (map[sx + dx[i]][sy + dy[i]] != '.') {
                sdir = i;
            }
        }

        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(sx, sy, sdir));
        boolean v[][] = new boolean[n + 1][m + 1];

        Point e = new Point(0, 0, 0);

        while (!q.isEmpty()) {
            Point p = q.poll();

            v[p.x][p.y] = true;

            int nx = p.x + dx[p.dir];
            int ny = p.y + dy[p.dir];

            if (map[nx][ny] == '.') { //빈 블록 발견
                e = new Point(nx, ny, p.dir);
                break;
            }
            int nextdir = nextDir(p.dir, map[nx][ny]);
            blockcnt--;
            q.offer(new Point(nx, ny, nextdir));
        }

        int i;
        int ndir = 0;
        int temp = blockcnt;

        for (i = 0; i < 6; i++) {// 게임을 무조건 완료할수 있기 떄문에 +는 제외하고 하나씩 대입함
            blockcnt = temp;
            ndir = nextDir(e.dir, block[i]);

            if (ndir == -1) //사용할수 없는 블록임
                continue;
            boolean complete = true;
            q.clear();
            q.offer(new Point(e.x, e.y, ndir));

            while (!q.isEmpty()) {//bfs 시작
                Point p = q.poll();
                v[p.x][p.y] = true;

                int nx = p.x + dx[p.dir];
                int ny = p.y + dy[p.dir];

                if (nx > n || ny > m || nx <= 0 || ny <= 0) { //경계선
                    complete = false;
                    break;
                }

                if (map[nx][ny] == 'Z' && blockcnt == 0) { //모든 블록을 사용해야만 게임이 완료된것임
                    break;
                }

                if (map[nx][ny] == '.') { //잘못된 블록
                    complete = false;
                    break;
                }

                if (v[nx][ny] && map[nx][ny] != '+') { // +를 제외한 블록은 한번만 방문가능
                    complete = false;
                    break;
                }

                int nextdir = nextDir(p.dir, map[nx][ny]);
                if (nextdir == -1) {
                    complete = false;
                    break;
                }
                blockcnt--;
                q.offer(new Point(nx, ny, nextdir));
            }

            if (complete)
                break;

        }

        System.out.printf("%d %d %c", e.x, e.y, block[i]);

    }
}
