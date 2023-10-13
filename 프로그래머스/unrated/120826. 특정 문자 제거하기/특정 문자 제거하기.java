class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        String[] chars = my_string.split("");
        for(String ch : chars){
            if(!ch.equals(letter)){
                answer+=ch;
            }
        }
        return answer;
    }
}