import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];

        for(int i=0; i<R; i++) {
            arr[i] = br.readLine().split("");
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());
            throwStick(i+1, height);
            findCluster();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void throwStick(int round, int height) {
        //홀수 -> 왼쪽에서 시작
        if (round % 2 != 0) {
            for(int i=0; i<C; i++) {
                if (arr[R - height][i].equals("x")) {
                    arr[R - height][i] = ".";
                    return;
                }
            }
        }
        //짝수 -> 오른쪽에서 시작
        else {
            for(int i = C-1; i >= 0; i--) {
                if (arr[R - height][i].equals("x")) {
                    arr[R - height][i] = ".";
                    return;
                }
            }
        }
    }

    public static void findCluster() {
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if (arr[i][j].equals("x") && !visited[i][j]) {
                    if (checkCluster(new Location(i,j))) {
                        return;
                    }
                }
            }
        }
    }

    public static boolean checkCluster(Location location) {
        int lowest = -1;

        Queue<Location> q = new LinkedList<>();
        List<Location> list = new ArrayList<>();

        q.add(location);
        visited[location.i][location.j] = true;

        while(!q.isEmpty()) {
            Location now = q.poll();
            lowest = Integer.max(lowest, now.i);
            list.add(now);

            for (int k=0; k<4; k++) {
                int cntX = now.i + dx[k];
                int cntY = now.j + dy[k];

                if (cntX < 0 || cntX >= R || cntY < 0 || cntY >= C) continue;

                if (!visited[cntX][cntY] && arr[cntX][cntY].equals("x")) {
                    visited[cntX][cntY] = true;
                    q.add(new Location(cntX, cntY));
                }
            }
        }
        if (lowest != R-1) {
            moveCluster(list);
            return true;
        }
        return false;
    }

    public static void moveCluster(List<Location> list) {
        int move = 1;

        for (Location location : list) {
            arr[location.i][location.j] = ".";
        }

        loop:
        while(true) {
            for (Location location : list) {

                if (location.i + move == R || arr[location.i + move][location.j].equals("x")) {
                    move--;
                    break loop;
                }
            }
            move++;
        }

        for (Location location : list) {
            arr[location.i + move][location.j] = "x";
        }
    }

    static class Location {

        int i;
        int j;

        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
