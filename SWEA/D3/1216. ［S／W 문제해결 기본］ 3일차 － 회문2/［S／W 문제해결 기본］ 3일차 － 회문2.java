
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int answer;
    static String[][] arr;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            arr = new String[100][100];
            answer = 0;

            for(int i=0; i<100; i++) {
                arr[i] = sc.next().split("");
            }

            for(int i=100; i>0; i--) {
                if(check(i) && i>answer) {
                    answer = i;
                }
            }

            System.out.println("#"+T+" "+answer);
        }
    }

    public static boolean check(int l) {
        for(int i=0; i<100; i++) {
            for(int j=0; j<=(100-l); j++) {
                if(checkRow(i,j,l) || checkCol(j,i,l)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkRow(int i, int j, int l) {
        for(int k=0; k<l/2; k++) {
            if(!arr[i][j+k].equals(arr[i][j+l-1-k])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int i, int j, int l) {
        for(int k=0; k<l/2; k++) {
            if(!arr[i+k][j].equals(arr[i+l-1-k][j])) {
                return false;
            }
        }
        return true;
    }
}