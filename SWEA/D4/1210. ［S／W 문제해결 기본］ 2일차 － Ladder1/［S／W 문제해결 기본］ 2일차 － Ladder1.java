
import java.util.Scanner;

class Solution {
    static int[] dx = {-1, 1};
    static String[][] arr;
    static boolean[][] visited;
    static int[] location;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            arr = new String[100][100];
            visited = new boolean[100][100];
            location = new int[2];

            for (int i = 0; i < 100; i++) {
                for (int j =0 ; j<100; j++) {
                    arr[i][j] = sc.next();
                }
            }
            for (int i = 0; i < 100; i++) {
                if (arr[99][i].equals("2")) {
                    location[0] = 99;
                    location[1] = i;
                    break;
                }
            }
            check();
            System.out.println("#" + test_case + " " + location[1]);
        }
    }

    public static void check() {
        while (location[0] != 0) {
            if (0 < location[1] && location[1] < 99) {
                boolean hasMoved = false;
                for (int i = 0; i < 2; i++) {
                    int cx = location[1] + dx[i];
                    if (!visited[location[0]][cx] && arr[location[0]][cx].equals("1")) {
                        visited[location[0]][location[1]] = true;
                        location[1] = cx;
                        hasMoved = true;
                        break;
                    }
                }
                if (!hasMoved) {
                    // 이동하지 않았을 때 실행할 코드를 여기에 추가합니다.
                    visited[location[0]][location[1]] = true;
                    location[0]--;
                }
            } else if (location[1] == 0) {
                if (!visited[location[0]][location[1] + 1] && arr[location[0]][location[1] + 1].equals("1")) {
                    visited[location[0]][location[1]] = true;
                    location[1]++;
                } else {
                    visited[location[0]][location[1]] = true;
                    location[0]--;
                }
            } else if (location[1] == 99) {
                if (!visited[location[0]][location[1] - 1] && arr[location[0]][location[1] - 1].equals("1")) {
                    visited[location[0]][location[1]] = true;
                    location[1]--;
                } else {
                    visited[location[0]][location[1]] = true;
                    location[0]--;
                }
            }
        }
    }
}