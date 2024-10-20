import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static int[][] arr;
    static final int INF = 987654321;
    static int minDistance;

    public static void main(String[] args) throws Exception {

        input();
        floydWarshall();
        searchMinCycle();

        if (minDistance == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }
    }

    private static void searchMinCycle() {
        minDistance = INF;
        for(int i=1; i < V; i++) {
            minDistance = Math.min(arr[i][i], minDistance);
        }
    }

    private static void floydWarshall() {
        for(int k=1; k <= V; k++) {
            for(int i=1; i <= V; i++) {
                if (arr[i][k] == INF) continue;
                for(int j=1; j <= V; j++) {
                    if (arr[k][j] == INF) continue;

                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new int[V + 1][V + 1];
        fillArrINF(arr);

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //a -> b 이동 거리 c
            arr[a][b] = c;
        }
    }

    private static void fillArrINF(int[][] arr) {
        for(int i=1; i<V+1; i++) {
            for(int j=1; j<V+1; j++) {
                arr[i][j] = INF;
            }
        }
    }
}

/**
 * V : 마을 개수
 * E : 도로
 * a, b, c : a -> b , c: 이동 거리
 */
