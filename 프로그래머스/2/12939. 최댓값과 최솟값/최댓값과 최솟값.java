class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(Integer.parseInt(arr[i]) < min) {
                min = Integer.parseInt(arr[i]);
            }
            if(Integer.parseInt(arr[i]) > max) {
                max = Integer.parseInt(arr[i]);
            }
        }
        String ans = Integer.toString(min) + " " + Integer.toString(max);
        return ans;
    }
}