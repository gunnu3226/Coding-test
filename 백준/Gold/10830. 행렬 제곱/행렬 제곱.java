import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long B;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st2.nextToken()) % 1000;
            }
        }

        int[][] result = pow(matrix, B);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] pow(int[][] A, long exponent) {

        if (exponent == 1) {
            return A;
        }

        int[][] ret = pow(A, exponent/2);

        ret = multiply(ret, ret);

        if (exponent % 2 == 1) {
            ret = multiply(ret, matrix);
        }
        return ret;
    }

    public static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[N][N];

        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }
        return ret;
    }
}
