import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int sum =0 ;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=1; i<=A.length;i++) {
            sum += A[i-1]*B[B.length-i];
        }
        return sum;
    }
}