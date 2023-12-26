import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length-2;i++) {
            int sum = 0;
            for(int j=i+1; j<nums.length-1;j++) {
                for(int k=j+1; k<nums.length;k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    
                    //소수 판별
                    if(primeCheck(sum)) {
                        answer++;
                    };
                }
            }
        }
        return answer;
    }
    
    public boolean primeCheck(int n) {
        boolean check = true;
        if(n==2) {
            return true;
        }
        for(int i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}