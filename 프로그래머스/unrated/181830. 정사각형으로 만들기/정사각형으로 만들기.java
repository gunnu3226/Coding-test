import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        if(arr.length==arr[0].length) return arr;
        int max = Math.max(arr.length,arr[0].length);
        int [][] answer = new int[max][max];
        
        for(int i=0;i<max;i++){
            for(int j=0;j<max;j++){
                if(i<arr.length&&j<arr[0].length){
                    answer[i][j] = arr[i][j];
                }
            }
        }
        return answer;
    }
}