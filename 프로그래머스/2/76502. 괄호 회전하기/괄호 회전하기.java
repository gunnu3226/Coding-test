import java.util.Stack;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        String str = s;

        for(int i=0; i<s.length(); i++) {
            char ch = str.charAt(0);
            str = str.substring(1) + ch;
            if(check(str)) {
                answer++;
            }
        }
        return answer;
    }
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
            }
            if(s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            }else if(s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            }else if(s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}