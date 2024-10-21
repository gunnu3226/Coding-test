import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] board;
    static String word;
    static long[][][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        word = br.readLine();
        dp = new long[N][M][word.length()];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result += dfs(i, j, 0);
                }
            }
        }

        System.out.println(result);
    }

    static long dfs(int x, int y, int index) {
        if (index == word.length() - 1) return 1;
        if (dp[x][y][index] != -1) return dp[x][y][index];

        dp[x][y][index] = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 1; k <= K; k++) {
                int nx = x + dx[i] * k;
                int ny = y + dy[i] * k;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == word.charAt(index + 1)) {
                    dp[x][y][index] += dfs(nx, ny, index + 1);
                }
            }
        }

        return dp[x][y][index];
    }
}