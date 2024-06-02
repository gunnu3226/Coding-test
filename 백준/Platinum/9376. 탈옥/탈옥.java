import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, h, w;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] prisonerA, prisonerB, sanggeun;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int t=0; t<n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h+2][w+2];
            Prisoner[] prisoners = new Prisoner[2];
            int prisonerIdx = 0;

            for(int i=0; i<h; i++) {
                String line = br.readLine();
                for(int j=0; j<w; j++) {
                    map[i+1][j+1] = line.charAt(j);
                    if (line.charAt(j) == '$') {
                        prisoners[prisonerIdx++] = new Prisoner(i+1, j+1, 0);
                    }
                }
            }

            prisonerA = bfs(prisoners[0]);
            prisonerB = bfs(prisoners[1]);
            sanggeun = bfs(new Prisoner(0, 0, 0));

            System.out.println(getMinimumSum());
        }
    }

    private static int[][] bfs(Prisoner prisoner) {
        PriorityQueue<Prisoner> q = new PriorityQueue<>();
        visited = new boolean[h+2][w+2];
        int[][] doorHistory = new int[h+2][w+2];

        q.add(prisoner);
        visited[prisoner.i][prisoner.j] = true;

        while(!q.isEmpty()) {
            Prisoner temp = q.poll();
            doorHistory[temp.i][temp.j] = temp.door;

            for(int i=0; i<4; i++) {
                int nx = temp.i + dx[i];
                int ny = temp.j + dy[i];

                if (nx < 0 || nx >= h+2 || ny < 0 || ny >= w+2 ||
                visited[nx][ny] || map[nx][ny] == '*') continue;

                visited[nx][ny] = true;
                q.add(new Prisoner(nx,ny, map[nx][ny]=='#' ? temp.door + 1 : temp.door));
            }
        }
        return doorHistory;
    }

    private static int getMinimumSum() {
        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                if (map[i][j] == '*') continue;

                int sum = prisonerA[i][j] + prisonerB[i][j] + sanggeun[i][j];

                if (map[i][j] == '#') sum -= 2;
                if (minSum > sum && visited[i][j]) minSum = sum;
            }
        }
        return minSum;
    }

    static class Prisoner implements Comparable<Prisoner>{
        int i, j, door;

        public Prisoner(int i, int j, int door) {
            this.i = i;
            this.j = j;
            this.door = door;
        }

        @Override
        public int compareTo(Prisoner o) {
            return Integer.compare(this.door, o.door);
        }
    }
}
