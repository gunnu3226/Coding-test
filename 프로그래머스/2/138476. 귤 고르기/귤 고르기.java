import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] count = new int[100000001];
        //count에 각 숫자의 개수 저장
        for(int i=0;i<tangerine.length; i++) {
            count[tangerine[i]]++;
        }
        Arrays.sort(count);
        int sum = 0;
        int idx = 100000000;
        while(sum < k) {
            answer++;
            sum += count[idx];
            idx--;
        }
        return answer;
    }
}