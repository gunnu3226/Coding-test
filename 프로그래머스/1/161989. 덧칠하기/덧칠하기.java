class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int location = section[0] + m - 1;

        for (int num : section) {
            if(num <= location) {
                continue;
            }
            answer++;
            location = num + m - 1;
        }
        return answer;
    }
}