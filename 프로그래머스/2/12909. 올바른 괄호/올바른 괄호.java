import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean solution(String s) {

        boolean result = false;
        Queue<String> q = new LinkedList<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                q.add("(");
            }
            if(s.charAt(i) == ')') {
                if(q.isEmpty()) {
                    return false;
                }
                q.poll();
            }
        }
        return q.isEmpty() ? true : false;
    }
}