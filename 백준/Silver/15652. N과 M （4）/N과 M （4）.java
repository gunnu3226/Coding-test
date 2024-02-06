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
        dfs(0,1);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int min) throws IOException {
        if(depth == m) {
            for (int i : arr) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=min; i<=n; i++) {
            arr[depth] = i;
            dfs(depth+1, i);
        }
    }
}