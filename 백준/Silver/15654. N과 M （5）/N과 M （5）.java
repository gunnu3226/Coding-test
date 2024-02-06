import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int n,m;
    static int[] arr;
    static int[] nums;
    static boolean[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        arr = new int[m];
        check = new boolean[n];
        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if(depth == m) {
            for (int i : arr) {
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i=0; i<n; i++) {
            if (check[i]) continue;
            arr[depth] = nums[i];
            check[i] = true;
            dfs(depth+1);
            check[i] = false;
        }
    }
}