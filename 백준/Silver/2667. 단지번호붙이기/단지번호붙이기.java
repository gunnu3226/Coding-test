import java.io.*;
import java.util.*;

public class Main {

    static int n, total;
    static List<Integer> list;
    static String[][] arr;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        check = new boolean[n][n];
        list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (arr[i][j].equals("1") && !check[i][j]) {
                    bfs(new Location(i,j));
                    total++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(total);
        for(Integer count : list) {
            System.out.println(count);
        }
    }

    public static void bfs(Location location) {
        int count = 1;
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        check[location.x][location.y] = true;

        while(!q.isEmpty()) {
            Location cntLocation = q.poll();

            for(int i=0; i<4; i++) {
                int cntX = cntLocation.x + dx[i];
                int cntY = cntLocation.y + dy[i];

                if (cntX < 0 || cntX >= n || cntY < 0 || cntY >= n) continue;

                if (arr[cntX][cntY].equals("1") && !check[cntX][cntY]) {
                    q.add(new Location(cntX, cntY));
                    check[cntX][cntY] = true;
                    count++;
                }
            }
        }
        list.add(count);
    }
    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
