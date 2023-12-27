import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map.put(players[i],i);
        }

        for(String call : callings) {
            int rank = map.get(call);
            map.put(call,rank-1);
            String change = answer[rank-1];
            map.put(change,rank);
            answer[rank-1] = answer[rank];
            answer[rank] = change;
            
        }
        return answer;
    }
}