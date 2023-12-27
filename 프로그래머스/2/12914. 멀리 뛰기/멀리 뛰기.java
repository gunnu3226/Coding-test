class Solution {
    public long solution(int n) {
        int[] fibo = new int[2001];
        fibo[1] = 1;
        fibo[2] = 2;
        for(int i=3;i<=n; i++) {
            fibo[i] = (fibo[i-2] + fibo[i-1]) % 1234567;
        }
        return fibo[n];
    }
}