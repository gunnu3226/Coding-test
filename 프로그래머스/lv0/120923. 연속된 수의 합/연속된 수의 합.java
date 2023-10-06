class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = 0;
        if(num%2==1){
            int middle = total/num;
            start = middle-((num-1)/2);
        } else{
            int j = 0;
            for(j=1;j<num;j++){
                start+=j;
            }
            start=(total-start)/num;
        }
        for(int i=0;i<num;i++){
            answer[i] = start+i;
        }
        return answer;
    }
}