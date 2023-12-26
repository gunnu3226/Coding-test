class Solution {
    public int solution(String s) {
        int answer = 1;
        String[] arr = s.split("");
        String cntstr = arr[0];
        int thiscount = 1;
        int othercount = 0;
        
        for(int i=1; i<arr.length; i++) {
            if(i == arr.length-1) {
                    return answer;
                }
            if(arr[i].equals(cntstr)) {
                thiscount++;
            } else if(!arr[i].equals(cntstr)) {
                othercount++;
            }
            if(thiscount == othercount) {
                cntstr = arr[i+1];
                answer++;
                thiscount = 0;
                othercount = 0;
            }
        }
        return answer;
    }
}