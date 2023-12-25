import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] location = new int[26];
        Arrays.fill(location,-1);

        for(int i=0; i<s.length(); i++) {
            char cntChar = s.charAt(i);
            int cntIdx = (int)(cntChar - 'a');

            if(location[cntIdx] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - location[cntIdx];
            }
            location[cntIdx] = i;
        }
        return answer;
    }
}