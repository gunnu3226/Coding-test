import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.length == 1) {
            return new int[]{-1};
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        for(int num : arr) {
            if(num != min) {
                list.add(num);
            }
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}