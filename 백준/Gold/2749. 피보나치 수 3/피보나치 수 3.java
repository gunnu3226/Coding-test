import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Long.parseLong(br.readLine()) % 1500000;
        if (n == 1L || n == 2L) {
            System.out.println(1);
        } else {
            System.out.println(fibo());
        }
    }

    public static long fibo() {
        long count = 1L;
        long pre = 1L;
        long cur = 1L;
        long next = 0L;


        while(count < n - 1) {
            next = (pre + cur) % 1000000;
            pre = cur;
            cur = next;
            count++;
        }
        return cur;
    }
}
