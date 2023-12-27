class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i=3; i<=brown; i++) {
            int x = i;
            int y = brown/2 + 2 - i;
            if((x-2)*(y-2) == yellow) {
                answer[0] = Math.max(x,y);
                answer[1] = Math.min(x,y);
                break;
            }
        }
        return answer;
    }
}