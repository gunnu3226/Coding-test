import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static String[][] arr;
    static int[][] count;
    static boolean[][]check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        count = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i] = str.split("");
            }
        }
        bfs(new Location(0,0));
        System.out.println(count[n-1][m-1]);
    }

    public static void bfs(Location location) {
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        check[location.x][location.y] = true;
        count[location.x][location.y] = 1;

        while(!q.isEmpty()) {
            Location cntLocation = q.poll();
            for(int i=0; i<4; i++) {
                int x = cntLocation.x + dx[i];
                int y = cntLocation.y + dy[i];
                if(0<=x && x < n && 0<=y && y< m){
                    if (!check[x][y] && arr[x][y].equals("1")) {
                        q.add(new Location(x,y));
                        check[x][y] = true;
                        count[x][y] = count[cntLocation.x][cntLocation.y] + 1;
                    }
                }

            }
        }
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}