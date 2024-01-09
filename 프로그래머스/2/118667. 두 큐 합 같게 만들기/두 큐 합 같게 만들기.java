import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long target = 0;
        long q1Sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i : queue1) {
            target += i;
            q1.add(i);
            q1Sum += i;
        }
        for (int i : queue2) {
            target += i;
            q2.add(i);
        }
        if(target%2 != 0) return -1;
        target /= 2;

        while(true) {
            if(answer > (queue1.length + queue2.length)*2) return -1;
            if(q1Sum == target) break;
            else if(q1Sum>target) {
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            } else {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
        }
        return answer;
    }
}