import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    static int[] count;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = new int[200000];
        q = new LinkedList<>();
        count[n] = 1;
        q.add(n);
        bfs();
        System.out.println(count[k]-1);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int cnt = q.poll();
            if(cnt == k) {
                return;
            }
            if(validate(2*cnt) && count[2*cnt] == 0) {
                count[2*cnt] = count[cnt]+1;
                q.add(2*cnt);
            }
            if(validate(cnt-1) && count[cnt-1] == 0) {
                count[cnt-1] = count[cnt]+1;
                q.add(cnt-1);
            }
            if(validate(cnt+1) && count[cnt+1] == 0) {
                count[cnt+1] = count[cnt]+1;
                q.add(cnt+1);
            }
        }
    }

    public static boolean validate(int num) {
        if(0<=num && num<200000) {
            return true;
        }
        return false;
    }
}