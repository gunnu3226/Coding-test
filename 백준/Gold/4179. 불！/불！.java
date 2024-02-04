import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r,c;
    static String[][] map;
    static int[][] fireTimeMap;
    static int[][] jMap;

    static Queue<Location> jq;
    static Queue<Location> fq;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        fireTimeMap = new int[r][c];
        jMap = new int[r][c];
        jq = new LinkedList<>();
        fq = new LinkedList<>();

        for(int i=0; i<r; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<c; j++) {
                map[i][j] = str[j];
                fireTimeMap[i][j] = -1;
                jMap[i][j] = -1;
                if (map[i][j].equals("J")) {
                    jq.add(new Location(i,j));
                    jMap[i][j] = 0;
                } else if (map[i][j].equals("F")) {
                    fq.add(new Location(i,j));
                    fireTimeMap[i][j] = 0;
                }
            }
        }
        fireBfs();
        jBfs();
    }

    public static void fireBfs() {
        while(!fq.isEmpty()) {
            Location cntLocation = fq.poll();
            for(int i=0; i<4; i++) {
                int x = cntLocation.x + dx[i];
                int y = cntLocation.y + dy[i];

                if (x < 0 || x >= r || y < 0 || y >= c) continue;
                if (fireTimeMap[x][y] >= 0 || map[x][y].equals("#")) continue;
                fq.add(new Location(x, y));
                fireTimeMap[x][y] = fireTimeMap[cntLocation.x][cntLocation.y] + 1;
            }
        }
    }

    public static void jBfs() {
        while(!jq.isEmpty()) {
            Location cntLocation = jq.poll();
            for(int i=0; i<4; i++) {
                int x = cntLocation.x + dx[i];
                int y = cntLocation.y + dy[i];

                if(x<0 || x>=r || y<0 || y>=c) {
                    System.out.println(jMap[cntLocation.x][cntLocation.y] + 1);
                    return;
                }
                if (jMap[x][y] >= 0 || map[x][y].equals("#")) continue;
                if (fireTimeMap[x][y] < 0 || jMap[cntLocation.x][cntLocation.y] + 1 < fireTimeMap[x][y]) {
                    jMap[x][y] = jMap[cntLocation.x][cntLocation.y] + 1;
                    jq.add(new Location(x,y));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
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