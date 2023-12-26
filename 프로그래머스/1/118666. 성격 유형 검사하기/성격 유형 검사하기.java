import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = new int[8];

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',1);
        map.put('C',2);
        map.put('F',3);
        map.put('J',4);
        map.put('M',5);
        map.put('A',6);
        map.put('N',7);
        int[] character = new int[8];

        for(int i=0; i<survey.length; i++) {
            if(choices[i]==4) {
                continue;
            }
            if(choices[i] < 4) {
                score[map.get(survey[i].charAt(0))] += 4-choices[i];
            } else if (choices[i] > 4 ) {
                score[map.get(survey[i].charAt(1))] += choices[i]-4;
            }
        }
        if(score[0]==score[1]) answer+="R";
        else if(score[0]>score[1]) answer+="R";
        else answer+="T";

        if(score[2]==score[3]) answer+="C";
        else if(score[2]>score[3]) answer+="C";
        else answer+="F";

        if(score[4]==score[5]) answer+="J";
        else if(score[4]>score[5]) answer+="J";
        else answer+="M";

        if(score[6]==score[7]) answer+="A";
        else if(score[6]>score[7]) answer+="A";
        else answer+="N";

        return answer;
    }
}