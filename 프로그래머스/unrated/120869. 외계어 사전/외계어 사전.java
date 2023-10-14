class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        for(String word : dic){
            int len = spell.length;
            for(String s : spell){
                if(word.contains(s)){
                    len-=1;
                }
            }
            if(len==0){
                answer = 1;  
                break;
            } else {
                answer = 2;
            }
        }
        return answer;
    }
}