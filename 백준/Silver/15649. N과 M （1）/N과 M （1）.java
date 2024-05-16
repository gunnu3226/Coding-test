import java.io.*;
import java.util.*;

public class Main {

    static boolean[] check;
    static int n, r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];

        combination(0,"");
    }

    public static void combination(int count, String str) {
        if(count == r) {
            System.out.println(str);
            return;
        }
        for(int i=1; i<=n; i++) {
            if (!check[i]) {
                check[i] = true;
                combination(count+1, str + i + " ");
                check[i] = false;
            }
        }
    }
}
