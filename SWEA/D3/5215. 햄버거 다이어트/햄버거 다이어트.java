
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int N, MAX_CAL, answer;
    static int[] score, cal;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            MAX_CAL = sc.nextInt();
            score = new int[N];
            cal = new int[N];
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            answer = 0;
            hamburger(0, 0, 0);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void hamburger(int index, int sum_score, int sum_cal) {

        if (sum_cal > MAX_CAL) {
            return;
        }
        if (sum_cal <= MAX_CAL) {
            answer = Math.max(sum_score, answer);
        }
        if (index == N) {
            return;
        }
        hamburger(index + 1, sum_score + score[index], sum_cal + cal[index]);
        hamburger(index + 1, sum_score, sum_cal);
    }

}