import java.util.*;
import java.io.*;

public class Main {

    static int n, m, r;
    static int[] visited;
    static List<Integer>[] graph;
    static int visitOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        //int[start][end]
        visited = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1; i<=n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        visited[start] = visitOrder++;
        for(int next : graph[start]) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
