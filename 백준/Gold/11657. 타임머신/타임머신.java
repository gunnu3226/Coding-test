import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long[] times = new long[n+1];
        Arrays.fill(times, INF);
        times[1] = 0;

        Edge[] edges = new Edge[m];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b ,c);
        }

        boolean isCycle = bellmanFord(times, edges);

        StringBuilder sb = new StringBuilder();
        if (isCycle) {
            sb.append(-1).append("\n");
        } else {
            for(int i=2; i < times.length; i++) {
                if (times[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(times[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord(long[] times, Edge[] edges) {
        boolean isMinusCycle = false;

        for(int i=1; i< n+1; i++) {
            for(int j=0; j < m; j++) {
                Edge cur = edges[j];

                if (times[cur.from] == INF) {
                    continue;
                }

                if (times[cur.to] > times[cur.from] + cur.time) {
                    times[cur.to] = times[cur.from] + cur.time;

                    if (i == n) {
                        isMinusCycle = true;
                        break;
                    }
                }
            }
        }
        return isMinusCycle;
    }
}

class Edge {
    int from;
    int to;
    int time;

    public Edge(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}
