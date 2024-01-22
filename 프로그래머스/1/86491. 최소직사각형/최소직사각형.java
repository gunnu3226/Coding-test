import java.nio.charset.IllegalCharsetNameException;
import java.util.Map;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;

        for (int[] size : sizes) {
                int cntMax = Math.max(size[0], size[1]);
                int cntMin = Math.min(size[0], size[1]);

                if(cntMax > max) max = cntMax;
                if(cntMin > min) min = cntMin;
        }

        return max * min;
    }
}