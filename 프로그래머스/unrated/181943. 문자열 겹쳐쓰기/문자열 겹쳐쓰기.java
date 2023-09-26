class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        String answer = my_string.substring(0,s) + overwrite_string;
        
        for(int i=answer.length(); i<my_string.length();i++){
            char ch = my_string.charAt(i);
            answer += ch;
        }
        return answer;
    }
}