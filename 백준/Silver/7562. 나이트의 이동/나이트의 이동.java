import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int l, endX, endY;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<T; tc++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            sb.append(bfs(new Knight(startX, startY, 0))).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(Knight knight) {
        Queue<Knight> queue = new LinkedList<>();
        queue.add(knight);
        visited[knight.x][knight.y] = true;

        while (!queue.isEmpty()) {
            Knight cnt = queue.poll();
            int x = cnt.x;
            int y = cnt.y;
            int moveCount = cnt.moveCount;

            if (x == endX && y == endY) {
                return moveCount;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Knight(nextX, nextY, moveCount+1));
                }
            }
        }
        return -1;
    }
}

class Knight {
    int x;
    int y;
    int moveCount;

    public Knight(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}
