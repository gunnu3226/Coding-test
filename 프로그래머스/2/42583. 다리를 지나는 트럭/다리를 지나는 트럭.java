import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;

        for(int truck : truck_weights) {
            
            while(true) {
                if(bridge.isEmpty()) {
                    bridge.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                } else {
                    if(sum + truck > weight) {
                        bridge.offer(0);
                        answer++;
                    } else {
                        bridge.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}