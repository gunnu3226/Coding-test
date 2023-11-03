
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int answer = 0;
            String[][] arr = new String[8][8];

            for (int i = 0; i < 8; i++) {
                arr[i] = sc.next().split("");
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 9 - n; j++) {
                    StringBuilder row = new StringBuilder();

                    for (int k=0; k<n; k++){
                        row.append(arr[i][j+k]);
                    }
                    if(판독기(row)){
                        answer++;
                    }
                }
            }

            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 9 - n; i++) {
                    StringBuilder col = new StringBuilder();

                    for (int k=0; k<n; k++){
                        col.append(arr[i+k][j]);
                    }
                    if(판독기(col)){
                        answer++;
                    }
                }
            }
            
            System.out.println("#"+test_case+" "+answer);
        }
    }

    public static boolean 판독기(StringBuilder str) {
        String str1 = str.toString();
        String str2 = str.reverse().toString();
        if(str1.equals(str2)){
            return true;
        }
        return false;
    }
}
