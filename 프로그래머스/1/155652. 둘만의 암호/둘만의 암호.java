class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int count = 1;
            while(count<=index) {
                ch++;
                if(ch > 'z') {
                    ch -= 26;
                }
                if(skip.contains(ch+"")) {
                    continue;
                } else 
                    count++;
            }
            answer += ch;
        }
        
        
        return answer;
    }
}