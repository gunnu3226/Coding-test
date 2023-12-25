class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=0; i<food.length; i++) {
            int foodcount = food[i]/2;
            for(int j=0; j<foodcount; j++) {
                answer += String.valueOf(i);
            }
        }
        String reverse = new StringBuilder(answer).reverse().toString();
        answer += "0" + reverse;
        return answer;
    }
}