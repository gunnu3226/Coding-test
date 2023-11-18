import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int N, M, max;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            max = 0;
            visited = new boolean[N+1];
            graph = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = graph[y][x] = 1;
            }
            for (int i = 1; i <= N; i++) {
                dfs(1, i);
                visited[i] = false;
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void dfs(int cnt, int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(cnt + 1, i);
                visited[i] = false;
            }
        }
        max = Math.max(cnt, max);
    }
}