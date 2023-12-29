import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for(int truck : truck_weights) {
            wait.offer(new Truck(truck));
        }
        int total = 0;

        while(!wait.isEmpty() || !bridge.isEmpty()) {
            answer++;

            if(bridge.isEmpty()) {
                Truck truck = wait.poll();
                total += truck.weight;
                bridge.offer(truck);
                continue;
            }

            for(Truck t : bridge) {
                t.moving();
            }

            if(bridge.peek().move > bridge_length) {
                total -= bridge.poll().weight;
            }
            
            if(!wait.isEmpty() && total + wait.peek().weight <= weight) {
                Truck t = wait.poll();
                total += t.weight;
                bridge.offer(t);
            }
        }
        return answer;
    }
}

class Truck {
    int weight;
    int move;

    public Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }

    public void moving() {
        move++;
    }
}