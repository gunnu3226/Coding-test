public class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i=0; i<4; i++) {
            int ch = h + dx[i];
            int cw = w + dy[i];
            if(0<=ch && ch< board.length && 0<=cw && cw< board.length) {
                if(board[ch][cw].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
