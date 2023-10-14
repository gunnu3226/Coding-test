import java.util.Stack;

class Solution {
    public Stack<Integer> solution(int[] arr) {
        int i = 0;
        Stack<Integer> stk = new Stack<>();
        
        for(int a : arr){
            if(stk.empty()){
            stk.push(a);
            } else if(stk.peek()==a){
                stk.pop();
            } else{
                stk.push(a);
            }
        }
        if(stk.empty()){
            stk.push(-1);
        }
        return stk;
    }
}