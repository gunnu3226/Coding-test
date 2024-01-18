class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        while(min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        
        int gcd = (n*m)/max;
        answer[0] = max;
        answer[1]= gcd;
        
        return answer;
    }
}