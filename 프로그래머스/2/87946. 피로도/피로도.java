class Solution {
    static boolean[] visited;
    static int count;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return count;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for(int i=0; i< dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }

}

//1.dfs를 사용한다.
//2.dungeons를 반복문으로 돌면서 피로도가 dungeons[i][0]보다 낮거나 방문한 경우 continue.
//3.다음 i칸을 visited true로 바꾸고 깊이를 추가하고 다음 재귀를 호출한다.
