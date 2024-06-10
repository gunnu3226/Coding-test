import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();

            for(int i=0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int s  = Integer.parseInt(st.nextToken());
                int e  = Integer.parseInt(st.nextToken());
                int t  = Integer.parseInt(st.nextToken());

                if (i >= m) {
                    edges.add(new Edge(s, e , -t));
                } else {
                    edges.add(new Edge(s, e , t));
                    edges.add(new Edge(e, s , t));
                }
            }
            int[] times = new int[n+1];

            if (checkMinusCycle(edges, times)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean checkMinusCycle(List<Edge> edges, int[] times) {
        boolean check = false;

        for(int i=1; i<n + 1; i++) {
            for(int j=0; j<edges.size(); j++) {
                Edge cur = edges.get(j);

                int time = times[cur.from] + cur.time;
                if (times[cur.to] > time) {
                    times[cur.to] = time;

                    if (i == n) {
                        check = true;
                    }
                }
            }
        }
        return check;
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
