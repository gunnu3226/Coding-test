import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] arr;
    static boolean[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        check = new boolean[n+1];
        dfs(0);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++) {
            if (check[i]) continue;
            arr[depth] = i;
            check[i] = true;
            dfs(depth+1);
            check[i] = false;
        }
    }
}