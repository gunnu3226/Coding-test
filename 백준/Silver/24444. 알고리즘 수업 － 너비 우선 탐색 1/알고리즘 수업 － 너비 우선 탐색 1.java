import java.util.*;
import java.io.*;

public class Main {

    static int n, m ,r;
    static int[] visited;
    static List<List<Integer>> graph;
    static int visitedOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
        graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0; i<n; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int next) {
        Queue<Integer> q = new LinkedList<>();
        visited[next] = visitedOrder++;
        q.add(next);

        while(!q.isEmpty()) {
            Integer cnt = q.poll();

            for(Integer num : graph.get(cnt)) {
                if (visited[num] == 0) {
                    visited[num] = visitedOrder++;
                    q.add(num);
                }
            }
        }
    }
}
