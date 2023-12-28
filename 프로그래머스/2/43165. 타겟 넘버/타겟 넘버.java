class Solution {
    int count;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers, target);
        return count;
    }
    
    public void dfs(int idx, int sum, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(sum == target) {
                count++;
                return;
            }
            return;
        }
        dfs(idx + 1, sum + numbers[idx], numbers, target);
        dfs(idx + 1, sum - numbers[idx], numbers, target);
    }
}