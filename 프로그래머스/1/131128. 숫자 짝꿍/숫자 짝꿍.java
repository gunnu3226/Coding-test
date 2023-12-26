import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] arrx = new int[10];
        int[] arry = new int[10];

        for (int i = 0; i < X.length(); i++) {
            arrx[X.charAt(i)-48]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            arry[Y.charAt(i)-48]++;
        }
        for (int i = 9; i >= 0; i--) {
            int min = Math.min(arrx[i], arry[i]);
            for (int j = 0; j < min; j++) {
                answer.append(i);
            }
        }
        if ("".equals(answer.toString())) {
            return "-1";
        } else if (answer.toString().charAt(0)==48) {
            return "0";
        }
        return answer.toString();
    }
}
