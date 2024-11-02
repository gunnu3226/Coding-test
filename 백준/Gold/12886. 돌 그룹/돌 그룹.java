import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B, C) ? 1 : 0);
    }

    static boolean bfs(int A, int B, int C) {

        if ((A + B + C) % 3 != 0) return false;

        Queue<Stone> q = new LinkedList<>();

        boolean[][] isChecked = new boolean[1501][1501];

        q.add(new Stone(A, B, C));
        isChecked[A][B] = true;

        while(!q.isEmpty()) {
            Stone s = q.poll();

            int cntA = s.A;
            int cntB = s.B;
            int cntC = s.C;

            if (cntA == cntB && cntB == cntC) return true;

            if (cntA != cntB) {
                int na = cntA > cntB ? cntA - cntB : cntA + cntA;
                int nb = cntA > cntB ? cntB + cntB : cntB - cntA;

                if (!isChecked[na][nb]) {
                    q.add(new Stone(na, nb, cntC));
                    isChecked[na][nb] = true;
                }
            }
            if (cntB != cntC) {
                int nb = cntB > cntC ? cntB - cntC : cntB + cntB;
                int nc = cntB > cntC ? cntC + cntC : cntC - cntB;

                if (!isChecked[nb][nc]) {
                    q.add(new Stone(cntA, nb, nc));
                    isChecked[nb][nc] = true;
                }
            }
            if (cntA != cntC) {
                int na = cntA > cntC ? cntA - cntC : cntA + cntA;
                int nc = cntA > cntC ? cntC + cntC : cntC - cntA;

                if (!isChecked[na][nc]) {
                    q.add(new Stone(na, cntB, nc));
                    isChecked[na][nc] = true;
                }
            }
        }
        return false;
    }

    static class Stone {
        int A, B, C;

        public Stone(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }
}