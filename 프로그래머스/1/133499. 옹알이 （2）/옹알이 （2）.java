import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = {"aya", "ye", "woo", "ma"};
        for(String str : babbling) {
            if(str.contains("ayaaya")||str.contains("yeye")||str.contains("woowoo")||str.contains("mama")) continue;
            for(int i=0; i<4; i++) {
                str = str.replaceAll(can[i]," ");
            }
            str = str.replace(" ","");
            if(str.length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}