class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        String answer = "";
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i].contains(" ")) {
                answer += arr[i];
                idx = 0;
            } else if(idx % 2 == 0) {
                answer += arr[i].toUpperCase();
                idx++;
            } else {
                answer += arr[i].toLowerCase();
                idx++;
            }
        }
        return answer;
    }
}