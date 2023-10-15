import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> hashMap = new HashMap<String, String>();
        
        for(String[] info : db){
            hashMap.put(info[0],info[1]);
        }
        if(hashMap.containsKey(id_pw[0])){
            if(hashMap.get(id_pw[0]).equals(id_pw[1])){
                return "login";    
            }else return "wrong pw";
        }else return "fail";
    }
}