import java.util.Arrays;

class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i< citations.length; i++){
            if((citations.length-i)<=citations[i]) {
                answer = citations.length-i;
                break;
            }
        }
        return answer;
    }
}