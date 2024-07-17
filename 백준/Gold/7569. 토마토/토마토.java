import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};

    static int n, m, h;
    static int[][][] box;
    static int troubleTomatoCount = 0;
    static int dayCount = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        //int[높이][row][col]
        box = new int[h+1][n+1][m+1];
        Queue<Loc> q = new LinkedList<>();

        for(int height=1; height<=h; height++) {
            for(int row=1; row<=n; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=1; col<=m; col++) {
                    int state = Integer.parseInt(st.nextToken());
                    box[height][row][col] = state;
                    if (state == 0) troubleTomatoCount++;
                    if (state == 1) q.add(new Loc(row, col, height));
                }
            }
        }
        if (troubleTomatoCount == 0) {
            System.out.println(0);
            return;
        }

        bfs(q);

        if (troubleTomatoCount != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dayCount);
    }

    static void bfs(Queue<Loc> q) {
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Loc cnt = q.poll();
                for(int d=0; d<6; d++) {
                    int nextRow = cnt.row + dx[d];
                    int nextCol = cnt.col + dy[d];
                    int nextH = cnt.h + dh[d];

                    if (nextRow <= 0 || nextRow > n ||
                    nextCol <=0 || nextCol > m ||
                    nextH <=0 || nextH > h) continue;

                    if (box[nextH][nextRow][nextCol] == 0) {
                        box[nextH][nextRow][nextCol] = 1;
                        q.add(new Loc(nextRow, nextCol, nextH));
                        troubleTomatoCount--;
                    }
                }
            }
            if(q.isEmpty()) continue;
            dayCount++;
        }
    }

    static class Loc {
        int row;
        int col;
        int h;

        public Loc(int row, int col, int h) {
            this.row = row;
            this.col = col;
            this.h = h;
        }
    }
}
