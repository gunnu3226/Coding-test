import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] lope = new Integer[N];
        for(int i=0; i<N; i++) {
            lope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lope, Collections.reverseOrder());
        int total = 0;
        for(int i=0; i<N; i++) {
            total = Math.max(total, lope[i] * (i+1));
        }
        System.out.println(total);
    }
}
