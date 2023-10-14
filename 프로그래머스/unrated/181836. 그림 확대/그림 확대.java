import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<>();
        
        for(String pic : picture){
            String[] chars = pic.split("");
            String str = "";
            for(String ch : chars){
                str+=ch.repeat(k);
            }
            for(int i=0;i<k;i++){
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}