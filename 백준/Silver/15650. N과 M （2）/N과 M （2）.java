import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
        dfs(0, 1);
    }

    static void dfs(int depth, int min) {
        if(depth == m) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=min; i<=n; i++) {
            if (check[i]) continue;
            arr[depth] = i;
            check[i] = true;
            dfs(depth+1, i+1);
            check[i] = false;
        }
    }
}