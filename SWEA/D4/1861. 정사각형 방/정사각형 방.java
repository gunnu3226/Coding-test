
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int N, max, roomnum;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Point> q;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];
            max = 0;
            roomnum = 1;
            //arr 입력받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxroom(i,j);
                }
            }
            System.out.println("#"+test_case+" "+roomnum+" "+max);
        }
    }

    public static void maxroom(int x, int y) {
        q = new LinkedList<>();
        int cntnum = 0;
        q.add(new Point(x,y));
        cntnum++;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i = 0; i< 4; i++) {
                int cx = now.x + dx[i];
                int cy = now.y + dy[i];

                if(cx>=0 && cx < N && cy >= 0 && cy <N) {
                    if(arr[now.x][now.y] + 1 == arr[cx][cy]) {
                        q.add(new Point(cx,cy));
                        cntnum++;
                    }
                }
            }
        }
        if(cntnum > max ) {
            max = cntnum;
            roomnum = arr[x][y];
        } else if(cntnum == max && arr[x][y] < roomnum) {
            max = cntnum;
            roomnum = arr[x][y];
        }
    }
}