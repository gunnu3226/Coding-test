import java.util.Scanner;

class Solution {
    static int N, answer;
    static int[] arr;
    static int[] weight;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N];
            weight = new int[N];
            visited = new boolean[N];
            answer = 0;
            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }
            permutation(0);
            System.out.println("#"+test_case+" "+answer);
        }
    }

    public static void permutation(int cnt) {
        if(cnt == N) {
            scale(0,0,0);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                weight[cnt] = arr[i];
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void scale(int num, int sumL, int sumR){
        if(num == N) {
            answer++;
            return;
        }
        scale(num + 1, sumL + weight[num], sumR);
        if(sumR + weight[num] <= sumL) {
            scale(num + 1, sumL, sumR + weight[num]);
        }
    }
}