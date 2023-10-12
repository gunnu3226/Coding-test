class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        String[] strarr = str1.split(str2);
        if(str1.contains(str2)){
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}
    