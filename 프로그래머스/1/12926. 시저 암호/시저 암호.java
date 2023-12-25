class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            if(ch == ' ') {
                answer += ch;
            } else if('a'<=ch && ch <= 'z') {
                answer += (char)('a' + (ch+n-'a')%26);
            } else {
                answer += (char)('A' + (ch+n-'A')%26);
            }
        }
            return answer;
    }
}