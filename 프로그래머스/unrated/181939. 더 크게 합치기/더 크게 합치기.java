class Solution {
    public int solution(int a, int b) {
        
        int answer = 0;
        Integer in1 = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        Integer in2 = Integer.parseInt(String.valueOf(b)+String.valueOf(a));
        
        answer = Math.max(in1,in2);
        return answer;
    }
}