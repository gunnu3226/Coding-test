import java.io.*;
import java.util.*;

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
        check = new boolean[n];
        arr = new int[m];
        dfs(0,0);
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
        for (int i=min; i<n; i++) {
            arr[depth] = nums[i];
            check[i] = true;
            dfs(depth+1, i+1);
            check[i] = false;
        }
    }
}