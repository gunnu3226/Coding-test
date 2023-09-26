class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        Integer int1 = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        Integer int2 = 2*a*b;
        answer = Math.max(int1,int2);
        return answer;
    }
}