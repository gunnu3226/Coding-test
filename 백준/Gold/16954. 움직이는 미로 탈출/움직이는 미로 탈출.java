import java.io.*;
import java.util.*;

public class Main {

    static int R = 8, C = 8;
    static char[][] map;
    static boolean[][] visited;
    static int possible = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0}; // 상하좌우 & 대각선 & 제자리 9방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws Exception {
        input();
        moveWJ();
        output();
    }

    public static void moveWJ() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(7,0));

        while(!queue.isEmpty()) {
            int size = queue.size();

            visited = new boolean[8][8];

            for(int i=0; i<size; i++) {
                Node current = queue.poll();

                if (map[current.x][current.y] == '#') continue;

                if (current.x == 0 && current.y == 7) {
                    possible = 1;
                    return;
                }

                for(int k=0; k<9; k++) {
                    int nx = current.x + dx[k];
                    int ny = current.y + dy[k];

                    if (nx < 0 || ny <0 || nx >= 8 || ny >= 8) continue;
                    if (visited[nx][ny] || map[nx][ny] == '#') continue;

                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            moveWall();
        }
        return;
    }

    public static void moveWall() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
                    }
                }
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];

        for(int i=0; i<8; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    public static void output() {
        System.out.println(possible);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
