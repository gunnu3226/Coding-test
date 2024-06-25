import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = n * n;
        for(int i=0; i <= n - 8; i++) {
            for(int j=0; j <= m - 8; j++) {
                answer = Math.min(answer, checkMinimumSquare(i, j));
            }
        }
        System.out.println(answer);
    }

    public static int checkMinimumSquare(int row, int col) {
        int white = 0; //첫번째가 하얀색인 경우
        int black = 0; //첫번째가 검은색인 경우

        for(int i=row; i < row+8; i++) {
            for(int j=col; j < col+8; j++) {
                //짝수 행의 경우 짝수열은 시작과 같고 홀수열은 반대
                if (i % 2 == 0) {
                    if(j % 2 == 0) {
                        if(map[i][j] == 'B') white++;
                        if(map[i][j] == 'W') black++;
                    }
                    //짝수행, 홀수 열
                    else {
                        if(map[i][j] == 'W') white++;
                        if(map[i][j] == 'B') black++;
                    }
                }
                //홀수 행의 경우 짝수열은 시작과 반대 홀수열은 같음
                else {
                    if(j % 2 == 0) {
                        if(map[i][j] == 'W') white++;
                        if(map[i][j] == 'B') black++;
                    } else {
                        if(map[i][j] == 'B') white++;
                        if(map[i][j] == 'W') black++;
                    }
                }
            }
        }
        return Math.min(white, black);
    }
}
