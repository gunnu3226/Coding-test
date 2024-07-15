import java.io.*;
import java.util.*;

public class Main {

    static int n, m, answer;
    static List<Integer>[] graph;
    static final int START_NUM = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        answer = 0;
        graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        bfs(START_NUM);
        System.out.println(answer);
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            Integer cnt = q.poll();

            for(Integer next : graph[cnt]) {
                if (visited[next]) continue;

                q.add(next);
                visited[next] = true;
                answer++;
            }
        }
    }
}
