import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int N, ans;
    static int[][] graph;
    static Queue<Integer> q;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int t = sc.nextInt();
            N = sc.nextInt();
            graph = new int[100][100];
            ans = 0;
            for(int i=0; i< N; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from][to] = 1;
            }
            search(0);
            System.out.println("#"+test_case+" "+ans);
        }
    }
    public static void search(int start) {
        q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cnt = q.poll();
            for(int i=0; i<100; i++) {
                if(graph[cnt][i] == 1) {
                    q.add(i);
                    if(i == 99) {
                        ans = 1;
                    }
                }
            }
        }
    }
}