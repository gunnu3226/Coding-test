import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        solution(new int[]{4, 3, 1, 2, 5});
    }
    public static int solution(int[] orders) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int cnt = 1;
        for (int order : orders) {
                while(cnt <= orders.length) {
                    if (cnt == order) {
                        break;
                    } else if(!stack.isEmpty() && stack.peek() == order) {
                        break;
                    }else {
                        stack.push(cnt);
                        cnt++;
                    }
                }
                if(cnt == order) {
                    cnt++;
                    answer++;
                } else if(!stack.isEmpty() && stack.peek() == order) {
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        return answer;
    }
}