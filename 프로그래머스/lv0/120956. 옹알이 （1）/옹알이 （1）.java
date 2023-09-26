class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String bab : babbling){
            bab = bab.replace("aya","0");
            bab = bab.replace("ye","0");
            bab = bab.replace("woo","0");
            bab = bab.replace("ma","0");
            bab = bab.replaceAll("0","");
            
            if (bab.equals("")){
                answer+=1;
            }
        }
        return answer;
    }
}