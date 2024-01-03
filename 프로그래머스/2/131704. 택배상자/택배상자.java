import java.util.Stack;

class Solution {
    public static int solution(int[] orders) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for(int i=1; i<=orders.length; i++) {
            if(i == orders[idx]) {
                answer++;
                idx++;
            } else {
                stack.add(i);
            }
            while(!stack.isEmpty() && stack.peek() == orders[idx]) {
                stack.pop();
                answer++;
                idx++;
            }
        }
        return answer;
    }
}