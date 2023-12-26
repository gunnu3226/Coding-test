import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6,6,5,4,3,2,1};
        int[] answer = new int[2];

        for(int lotto : lottos) {
            if(lotto == 0) {
                answer[0]++;
                continue;
            }
            for(int win : win_nums) {
                if(win == lotto) {
                    answer[0]++;
                    answer[1]++;
                }
            }
        }
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        return answer;
    }
}