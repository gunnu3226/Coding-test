import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(3,2,5));
    }
    public static int[] solution(int n, long left, long right) {
//        int[][] arr2 = new int[n][n];
//        int num = 1;
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                arr2[i][j] = Math.max(i+1,j+1);
//            }
//        }
        int count = (int) (right-left+1);
        int[] answer = new int[count];
        for(int i = 0; i<count; i++) {
            //answer[i] = arr2[(int) ((left+i)/n)][(int) ((left+i)%n)];
            answer[i] = Math.max(((int) ((left+i)/n+1)),((int) ((left+i)%n+1)));

        }
        return answer;
    }
}