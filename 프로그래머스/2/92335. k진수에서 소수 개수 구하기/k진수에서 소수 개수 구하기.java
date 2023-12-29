class Solution {
    public static int solution(int n, int k) {
        int answer = 0;
        String change = Integer.toString(n,k);

        for(String str : change.split("0")) {
            if(str.equals("")) continue;
            long num = Long.parseLong(str);
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long n) {
        if(n<2) return false;

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
}