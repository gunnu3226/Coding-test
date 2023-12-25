class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int next = 1;
        int cnt = n;
        while(next!=0) {
            next = (cnt/a)*b;
            answer += next;
            cnt = next + (cnt%a);
        }
        return answer;
    }
}