class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];

        int x = 0;
        int y = 0;
        int value = 1;
        arr[0][0] = 1;
        
        while(value < n*(n+1)/2) {
            while( x+1 < n && arr[x+1][y] == 0) {
                arr[++x][y] = ++value;
            }
            while( y+1 < n && arr[x][y+1] == 0) {
                arr[x][++y] = ++value;
            }
            while(x-1>0 && y-1>0 && arr[x-1][y-1] == 0) {
                arr[--x][--y] = ++value;
            }
        }
        int idx = 0;
        for (int i=0; i< arr.length; i++) {
            for(int j=0; j<=i; j++) {
                answer[idx++] = arr[i][j];
            }
            
        }
        return answer;
    }
}