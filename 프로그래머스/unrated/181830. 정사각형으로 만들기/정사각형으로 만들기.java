import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        if(arr.length==arr[0].length){
            return arr;
        }else if(arr.length<arr[0].length){
            int[][] answer_a = new int[arr[0].length][arr[0].length];
            for(int i=0;i<arr.length;i++){
                answer_a[i] = arr[i];
            }
            int[] zero = new int[arr[0].length];
            for(int j=arr.length;j<arr[0].length;j++){
                answer_a[j] = zero;
            }
            return answer_a;
        }else if(arr.length>arr[0].length){
            int[][] answer_b = new int[arr.length][arr.length];
            for(int l=0;l<arr.length;l++){
                int[] in = new int[arr.length];
                for(int k=0;k<arr[0].length;k++){
                    in[k] = arr[l][k];
                }
                answer_b[l] = in;
            }
            return answer_b;
        }
        return null;
    }
}