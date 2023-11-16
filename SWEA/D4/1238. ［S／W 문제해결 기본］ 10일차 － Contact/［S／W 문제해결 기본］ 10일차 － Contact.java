import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int N, start;
    static int[][] arr;
    static Queue<Integer> q;
    static boolean[] visited;


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            N = sc.nextInt();
            start = sc.nextInt();
            visited = new boolean[101];
            arr = new int[101][101];
            q = new LinkedList<>();

            for (int i = 0; i < N / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                arr[from][to] = 1;
            }
            System.out.print("#" + test_case + " ");
            contact(start);
        }
    }

    public static void contact(int start) {
        q.add(start);
        int max = 0;
        visited[start] = true;
        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int qsize = q.size();
            max = 0;

            for (int i = 0; i < qsize; i++) {
                int cnt = q.poll();
                for (int j = 1; j <= 100; j++) {
                    if (arr[cnt][j] == 1 & visited[j] == false) {
                        q.add(j);
                        visited[j] = true;
                        max = Math.max(max, j);
                    }
                }
            }
            list.add(max);
        }
        System.out.println(list.get(list.size() - 2));
    }
}