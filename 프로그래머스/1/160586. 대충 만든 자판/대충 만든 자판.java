import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alphabet = new int[26];
        Arrays.fill(alphabet,101);
        
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                alphabet[keymap[i].charAt(j)-'A'] = Math.min(alphabet[keymap[i].charAt(j)-'A'],j+1);
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            for(int j=0; j<targets[i].length(); j++) {
                if(alphabet[targets[i].charAt(j)-'A']==101) {
                    sum = -1;
                    break;
                }
                else sum += alphabet[targets[i].charAt(j)-'A'];
            }
            answer[i] = sum;
        }
        return answer;
    }
}