import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k, length;
    static int[] visited = new int[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String num  = st.nextToken();
        length = num.length();
        n = Integer.parseInt(num);
        k = Integer.parseInt(st.nextToken());
        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty() && k > 0) {
            int size = q.size();

            for(int x=0; x<size; x++) {
                int now = q.poll();

                for(int i=0; i<length - 1; i++) {
                    for(int j=i+1; j<length; j++) {
                        int next = swap(now, i, j);

                        if (next != 0 && visited[next] != k) {
                            q.add(next);
                            visited[next] = k;
                        }
                    }
                }
            }
            k--;
        }
        if (q.isEmpty()) {
            System.out.println("-1");
            return;
        }
        int answer = 0;
        for(int num : q) {
            answer = Math.max(num, answer);
        }
        System.out.println(answer);
    }

    public static int swap(int now, int i, int j) {
        char[] list = String.valueOf(now).toCharArray();

        char temp = list[i];
        list[i] = list[j];
        list[j] = temp;

        if(list[0]=='0')
            return 0;

        return Integer.parseInt(new String(list));
    }
}
