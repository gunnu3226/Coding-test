
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int n, m, total;
    static int[] fee, weight;
    static int[] parking;
    static Queue<Integer> wait;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            total = 0;

            //주차칸 주차요금 입력
            fee = new int[n];
            for (int i = 0; i < n; i++) {
                fee[i] = sc.nextInt();
            }

            //차량 무게 입력
            weight = new int[m];
            for (int i = 0; i < m; i++) {
                weight[i] = sc.nextInt();
            }

            parking = new int[n];
            wait = new LinkedList<>();
            for (int i = 0; i < 2 * m; i++) {
                int carnum = sc.nextInt();
                //주차
                if (carnum > 0) {
                    int check = 0;
                    for (int j = 0; j < n; j++) {
                        if (parking[j] == 0) {
                            parking[j] = carnum;
                            total += fee[j] * weight[carnum - 1];
                            check = 1;
                            break;
                        }
                    }
                    if (check == 0) {
                        wait.add(carnum);
                    }
                } else { //출차
                    int carnum2 = Math.abs(carnum);
                    for (int j = 0; j < n; j++) {
                        if (parking[j] == carnum2) {
                            parking[j] = 0;
                            if (!wait.isEmpty()) {
                                int waitingcar = wait.poll();
                                parking[j] = waitingcar;
                                total += fee[j] * weight[waitingcar - 1];
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + total);
        }
    }
}