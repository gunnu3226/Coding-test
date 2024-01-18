class Solution {

    public static void main(String[] args) {
        solution(13, 17);
    }
    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
            if(약수개수짝홀(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public static boolean 약수개수짝홀(int n) {
        int count = 0;
        for(int i=1; i*i<=n; i++) {
            if(n % i == 0) {
                if(i*i == n) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        if((count & 1) == 0) return true;
        else return false;
    }
}