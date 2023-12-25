import java.util.Arrays;

class Solution {
    int[] answer = {};
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length;i++) {
            answer[i] = k번째수(array,commands[i]);
        }
        return answer;
    }
    
    public int k번째수(int[] arr, int[] command) {
        int[] arr2 = new int[command[1]-command[0]+1];
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = arr[command[0]-1+i];
        }
        Arrays.sort(arr2);
        return arr2[command[2]-1];
    }
}