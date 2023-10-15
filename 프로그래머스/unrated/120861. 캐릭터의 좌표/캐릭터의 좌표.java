class Solution {
    String up = "up";
        String down = "down";
        String left = "left";
        String right = "right";
        int[] answer = {0,0};
        int max_heigt = 0;
        int max_width = 0;
    
    public int[] solution(String[] keyinput, int[] board) {
        max_heigt = board[1]/2;
        max_width = board[0]/2;
        for(String key : keyinput){
            move(key);
        }
        return answer;
    }
    
    public void move(String key){
        if(up.equals(key)){
            moveUp();
        }else if(down.equals(key)){
            moveDown();
        }else if(left.equals(key)){
            moveLeft();
        }else if(right.equals(key)){
            moveRight();
        }
    }
    
    public void moveUp(){
        int top = max_heigt;
        if(answer[1]<top){
            answer[1]++;
        };
    }
    
    public void moveDown(){
        int bottom = max_heigt*-1;
        if(answer[1]>bottom){
            answer[1]--;
        };
    }
    
    public void moveRight(){
        int right = max_width;
        if(answer[0]<right){
            answer[0]++;
        };
    }
    
    public void moveLeft(){
        int left = max_width*-1;
        if(answer[0]>left){
            answer[0]--;
        };
    }
}