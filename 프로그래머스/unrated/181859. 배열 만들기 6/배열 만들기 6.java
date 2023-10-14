import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i=0;
        ArrayList<Integer> stk = new ArrayList<>();
        while(i<arr.length){
            if(stk.isEmpty()){
                stk.add(arr[i]);
                i++;
            }else if(stk.get(stk.size() - 1)==arr[i]){
               stk.remove(stk.size() - 1);
               i++;
           }else if(stk.get(stk.size() - 1)!=arr[i]){
                stk.add(arr[i]);
                i++;
            }
        }
        int[] answer = new int[stk.size()];
        for (int j = 0; j < stk.size(); j++) {
            answer[j] = stk.get(j);
        }
        return stk.isEmpty()? new int[]{-1} : answer;
    }
}