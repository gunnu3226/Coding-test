class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i=0; i<section.length; i++) {
            check[section[i]-1] = true;
        }
        for(int i=check.length-1; i>=0; i--) {
            if(check[i]) {
                answer++;
                for(int j=0;j<m;j++) {
                    if((i-j)>=0){
                        check[i-j] = false;
                    }
                }
            }
        }
        return answer;
    }
}