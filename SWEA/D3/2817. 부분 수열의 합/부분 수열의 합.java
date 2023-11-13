
import java.util.Scanner;

class Solution {
    static int N;
    static int K;
    static int count;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            count = 0;
            powerset(0,0);

            System.out.println("#"+test_case+" "+count);
        }
    }

    public static void powerset(int index, int sum) {
        if(index == N) {
            if(sum == K){
                count++;
            }
            return;
        } else {
            powerset(index + 1, sum);
            sum += arr[index];
            powerset(index + 1, sum);
        }
    }
}