class Solution {
    public int solution(int[][] dots) {
        int x_min = dots[0][0];
        int x_max = dots[0][0];
        int y_min = dots[0][1];
        int y_max = dots[0][1];
        
        for(int[]dot : dots){
            if(dot[0]<x_min){
                x_min = dot[0];
            }else if(dot[0]>x_max){
                x_max = dot[0];
            }
            if(dot[1]<y_min){
                y_min = dot[1];
            }else if(dot[1]>y_max){
                y_max = dot[1];
            }
        }
        
        int answer = (x_max-x_min)*(y_max-y_min);
        return answer;
    }
}