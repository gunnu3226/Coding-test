
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    static int N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] data = sc.next().split("");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(data[j]);
                }
            }
            int ans = bfs();
            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static int bfs() {
        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        int dis = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == N - 1 && node.y == N - 1) {
                dis = Math.min(dis, node.dis);
            }

            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int distance = node.dis + arr[nx][ny];

                    if (visited[nx][ny] > distance) {
                        visited[nx][ny] = distance;
                        q.add(new Node(nx, ny, distance));
                    }
                }
            }
        }
        return dis;
    }
}