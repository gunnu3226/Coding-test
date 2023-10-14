import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        int[] karr = Arrays.stream(arr).distinct().toArray();
        
        for(int i=0;i<k;i++){
            if(i<karr.length){
                answer[i]=karr[i];
            }else{
                answer[i]=-1;
            }
        }
        return answer;
    }
}