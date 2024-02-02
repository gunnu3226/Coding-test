import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] arr;
    static int[][] count;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Location> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        count = new int[n][m];
        q = new LinkedList<>();

        boolean finish = true;
        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == 0) {
                    finish=false;
                } else if (arr[i][j] == 1) {
                    q.add(new Location(i,j));
                }
            }
        }
        if(finish) {
            System.out.println(0);
            return;
        }
        bfs();
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max,arr[i][j]);
            }
        }
        System.out.println(max-1);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Location cntLocation = q.poll();
            for(int i=0; i<4; i++) {
                int x = cntLocation.x + dx[i];
                int y = cntLocation.y + dy[i];

                if(0<=x && x<n & 0<=y && y<m) {
                    if(arr[x][y] != -1) {
                        if(arr[x][y] == 0) {
                            q.add(new Location(x,y));
                            arr[x][y] = arr[cntLocation.x][cntLocation.y] + 1;
                        }
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

/**
 * 1. 입력받고
 * 2. 2차원배열 돌면서 1일때 bfs실행, 1인거 찾아서 실행하기
 * 3. 해당 count[현재위치]+1 이 원래 count보다 작다면 업데이트
 * 4. bfs가 끝나고 2차원 배열을 돌면 0인게 있으면 -1을 출력
 */
