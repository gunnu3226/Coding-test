import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] rank = {0,0,0};
        int[] man1 = {1,2,3,4,5}; //5
        int[] man2 = {2,1,2,3,2,4,2,5}; //8
        int[] man3 = {3,3,1,1,2,2,4,4,5,5};  //10
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == man1[i%5]) {
                rank[0]++;
            }
            if(answers[i] == man2[i%8]) {
                rank[1]++;
            }
            if(answers[i] == man3[i%10]) {
                rank[2]++;
            }
        }
        
        int max = Math.max(rank[0],Math.max(rank[1],rank[2]));
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<3;i++) {
            if(rank[i] == max) {
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}