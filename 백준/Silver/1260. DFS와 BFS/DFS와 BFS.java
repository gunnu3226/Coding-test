import java.io.*;
import java.util.*;

public class Main {

    static int n, m, v;
    static List<Integer>[] graph;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=0; i<=n; i++) {
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();

        dfs(v, new boolean[n+1]);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int start, boolean[] visited) {
        sb.append(start).append(" ");
        visited[start] = true;

        for (Integer next : graph[start]) {
            if (visited[next]) continue;

            visited[next] = true;
            dfs(next, visited);
        }
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!q.isEmpty()) {
            Integer cnt = q.poll();

            for(Integer next : graph[cnt]) {
                if (visited[next]) continue;

                q.add(next);
                visited[next] = true;
                sb.append(next).append(" ");
            }
        }
    }
}
