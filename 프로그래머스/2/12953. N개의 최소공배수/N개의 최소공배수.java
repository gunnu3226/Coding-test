import java.util.*;

class Solution {
    static int answer = 0;
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int idx = 1;
        while(!check(arr,max*idx)) {
            idx++;
        }
        return answer;
    }

    public static boolean check(int[] arr, int n) {
        for(int i=0; i<arr.length; i++) {
            if(n%arr[i]!=0) {
                return false;
            }
        }
        answer = n;
        return true;
    }
}