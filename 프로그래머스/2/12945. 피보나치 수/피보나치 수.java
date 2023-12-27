class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    public static int solution(int n) {
        int[] answer = new int[n+2];

        for(int i=0; i<=n; i++) {
            if(i==0) answer[i] = 0;
            else if (i==1) {
                answer[i] = 1;
            } else {
                int sum = answer[i-2] + answer[i-1];
                answer[i] = sum%1234567;
            }
        }
        return answer[n];
    }
}

