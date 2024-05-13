import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    static int[][] arr;
    static boolean check;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            arr = new int[9][9];
            for(int i=0; i<9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            check = false;
            rowCheck(tc);
            columnCheck(tc);
            boxCheck(tc);
            if (check) {
                System.out.println("#"+tc+" 0");
            } else {
                System.out.println("#"+tc+" 1");
            }
        }
    }

    public static void rowCheck(int tc) {
        for(int i=0; i<9; i++) {
            int[] row = new int[9];
            for(int j=0; j<9; j++) {
                row[j] = arr[i][j];
            }
            Arrays.sort(row);
            int k=1;
            for(int l=0; l<9; l++) {
                if(row[l] != k++) {
                    check = true;
                    return;
                }
            }
        }
    }

    public static void columnCheck(int tc) {
        for(int i=0; i<9; i++) {
            int[] col = new int[9];
            for(int j=0; j<9; j++) {
                col[j] = arr[j][i];
            }
            Arrays.sort(col);
            int k=1;
            for(int l=0; l<9; l++) {
                if(col[l] != k++) {
                    check = true;
                    return;
                }
            }
        }
    }

    public static void boxCheck(int tc) {
        for(int i=0; i<3; i+=3) {
            boolean[] box = new boolean[9];
            for(int j=0; j<3; j+=3) {
                for(int k=0; k<3; k++) {
                    for(int l=0; l<3;l++) {
                        box[arr[i+k][j+l]-1] = true;
                    }
                }
                for(int k=0; k<9; k++) {
                    if(!box[k]) {
                        check = true;
                        return;
                    }
                }
            }
        }
    }
}