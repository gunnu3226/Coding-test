import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> frontMap = new HashMap<>();
        Map<Integer, Integer> backMap = new HashMap<>();

        for(int top : topping) {
            backMap.put(top,backMap.getOrDefault(top,0)+1);
        }
        for(int top: topping) {
            frontMap.put(top, frontMap.getOrDefault(top,0) + 1);

            if(backMap.get(top) - 1 == 0) {
                backMap.remove(top);
            } else {
                backMap.put(top, backMap.get(top) - 1);
            }
            
            if(frontMap.size()== backMap.size()) {
                answer++;
            }
        }
        return answer;
    }
}