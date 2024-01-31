class Solution {
    public int solution(int n) {
        long nCount = Integer.bitCount(n);
        int answer = n+1;
        while(true) {
            long count = Integer.bitCount(answer);
            if(nCount == count) {
                break;
            }
            answer++;
        }
        return answer;
    }
}