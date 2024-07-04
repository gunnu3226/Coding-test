import java.io.*;
import java.util.*;

public class Main {

    static List<Cctv> cctvList = new ArrayList<>();
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static int N, M;
    static int[][] office;
    static int answer = 100;

    static int[][] dir = {
        {},
        {1},
        {1, 3},
        {0, 1},
        {0, 1, 3},
        {0, 1, 2, 3}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N+1][M+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                if (1 <= office[i][j] && office[i][j] <= 5) {
                    int num = office[i][j];
                    cctvList.add(new Cctv(i, j, num));
                }
            }
        }

        dfs(0, office);
        System.out.println(answer);
    }

    private static void dfs(int cctvCount, int[][] office) {
        if(cctvCount == cctvList.size()) {
            answer = Math.min(answer, getBlindSpotCount(office));
            return;
        }

        int row = cctvList.get(cctvCount).row;
        int col = cctvList.get(cctvCount).col;
        int num = cctvList.get(cctvCount).num;

        for(int d=0; d<4; d++) {
            int[][] copiedOffice = getDeepCopiedOffice(office);

            for(int move : dir[num]) {
                int nd = (move + d) % 4;
                int nr = row;
                int nc = col;

                while(true) {
                    nr += dr[nd];
                    nc += dc[nd];

                    if (!isValidIndex(nr, nc)) {
                        break;
                    }

                    copiedOffice[nr][nc] = -1;
                }
            }

            dfs(cctvCount + 1, copiedOffice);
        }
    }

    private static int getBlindSpotCount(int[][] copiedOffice) {
        int blindSpotCount = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (copiedOffice[i][j] == 0) {
                    blindSpotCount++;
                }
            }
        }
        return blindSpotCount;
    }

    private static int[][] getDeepCopiedOffice(int[][] office) {
        int[][] deepCopiedOffice = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                deepCopiedOffice[i][j] = office[i][j];
            }
        }
        return deepCopiedOffice;
    }

    private static boolean isValidIndex(int row, int col) {
        if(row < 0 || row >= N) {
            return false;
        }
        if(col < 0 || col >= M) {
            return false;
        }
        // 벽
        if(office[row][col] == 6) {
            return false;
        }

        return true;
    }
}

class Cctv {
    int row;
    int col;
    int num;

    public Cctv(int row, int col, int num) {
        this.row = row;
        this.col = col;
        this.num = num;
    }
}
