class Solution {

    static int memo1;
    static int memo2;

    public static void main(String[] args) {
        solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int answeridx = 0;

        //기본 맵 생성
        int[][] map = new int[rows][columns];
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                map[i-1][j-1] = (i-1)*columns+j;
            }
        }

        //0:시작행,2:끝행, 1:시작열,3:끝열
        for (int[] query : queries) {
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            int firstNum = map[x1][y2];
            int min = firstNum;

            for(int i=y2-1; i>=y1; i--) {
                min = Math.min(min, map[x1][i]);
                map[x1][i+1] = map[x1][i];
            }
            for(int i=x1+1; i<=x2; i++) {
                min = Math.min(min, map[i][y1]);
                map[i-1][y1] = map[i][y1];
            }
            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, map[x2][i]);
                map[x2][i-1] = map[x2][i];
            }
            for(int i=x2-1; i>=x1; i--) {
                min = Math.min(min,map[i][y2]);
                map[i+1][y2] = map[i][y2];
            }

            map[x1+1][y2] = firstNum;
            answer[answeridx++] = min;
        }
        return answer;
    }
}