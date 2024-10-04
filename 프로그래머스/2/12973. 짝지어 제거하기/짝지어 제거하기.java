import java.util.*;

class Solution
{
    public int solution(String s)
    {
        char[] ch_arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<ch_arr.length; i++) {
            char c = ch_arr[i];
            
            if(stack.isEmpty()) stack.push(c);
            else {
                if(stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}