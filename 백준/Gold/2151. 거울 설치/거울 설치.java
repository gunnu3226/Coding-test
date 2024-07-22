import java.io.*;
import java.util.*;

public class Main {

    static int n, sx, sy, min;
    static char[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i=0; i<n; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<n; j++) {
                map[i][j] = arr[j];
                if (arr[j] == '#') {
                    sx = i;
                    sy = j;
                }
            }
        }
        min = Integer.MAX_VALUE;
        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        int[][][] visited = new int[n][n][4];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        for (int i=0; i<4; i++) {
            q.add(new Loc(sx, sy, i, 0));
            visited[sx][sy][i] = 0;
        }

        while(!q.isEmpty()) {
            int q_len = q.size();

            for(int i=0; i<q_len; i++) {
                Loc loc = q.poll();

                int nx = loc.x + dx[loc.dir];
                int ny = loc.y + dy[loc.dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n ||
                    visited[nx][ny][loc.dir] < loc.count
                    || map[nx][ny] == '*') continue;

                if (map[nx][ny] == '.') {
                    visited[nx][ny][loc.dir] = loc.count;
                    q.add(new Loc(nx, ny, loc.dir, loc.count));
                }
                else if (map[nx][ny] == '!') {
                    visited[nx][ny][loc.dir] = loc.count;
                    q.add(new Loc(nx, ny, loc.dir, loc.count));

                    if (loc.dir <= 1) {
                        visited[nx][ny][2] = loc.count;
                        visited[nx][ny][3] = loc.count;
                        q.add(new Loc(nx, ny, 2, loc.count + 1));
                        q.add(new Loc(nx, ny, 3, loc.count + 1));
                    } else {
                        visited[nx][ny][0] = loc.count;
                        visited[nx][ny][1] = loc.count;
                        q.add(new Loc(nx, ny, 0, loc.count + 1));
                        q.add(new Loc(nx, ny, 1, loc.count + 1));
                    }
                }
                else if(map[nx][ny] == '#'){
                    min = Math.min(min, loc.count);
                }
            }
        }
    }

    static class Loc {
        int x;
        int y;
        int dir;
        int count;

        public Loc(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
}
