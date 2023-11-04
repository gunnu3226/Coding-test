
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int answer = 0;
            int x = 좌표계산기(p)[0] + 좌표계산기(q)[0];
            int y = 좌표계산기(p)[1] + 좌표계산기(q)[1];
            answer = 값계산기(x,y);

            System.out.println("#"+test_case+" "+answer);
        }
    }

    public static int 값계산기(int x, int y) {
        int score;
        int xsum = 0;
        int ysum = 0;
        for (int i = 1; i <= x; i++) {
            xsum += i;
        }
        for (int j = 0; j < y - 1; j++) {
            ysum += (x + j);
        }
        score = xsum + ysum;
        return score;
    }

    public static int[] 좌표계산기(int p) {
        int sum = 1;
        int index = 1;
        int x = 1;
        int y = 0;
        int[] coordinate = new int[2];

        while (sum < p) {
            index++;
            sum += index;
        }
        sum -= index;
        index -= 1;
        x = p - sum;
        y = index - x + 2;
        coordinate[0] = x;
        coordinate[1] = y;
        return coordinate;
    }
}