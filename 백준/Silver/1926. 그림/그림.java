import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m, count, max;
    static boolean[][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;
        count = 0;
        int[][] arr = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!check[i][j] && arr[i][j]==1) {
                    bfs(new Locate(i,j), arr);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(Locate locate, int[][] arr) {
        int sum = 0;
        Queue<Locate> q = new LinkedList<>();
        q.add(locate);
        check[locate.x][locate.y] = true;

        while(!q.isEmpty()) {
            Locate cntlocate = q.poll();
            sum++;
            for(int i=0; i<4; i++) {
                int x = cntlocate.x + dx[i];
                int y = cntlocate.y + dy[i];
                if(0<=x && x<n && 0<=y && y<m) {
                    if(!check[x][y] && arr[x][y] == 1) {
                        q.add(new Locate(x,y));
                        check[x][y] = true;
                    }
                }
            }
        }
        if(sum>max) max =sum;
    }
}

class Locate {
    int x;
    int y;

    public Locate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
