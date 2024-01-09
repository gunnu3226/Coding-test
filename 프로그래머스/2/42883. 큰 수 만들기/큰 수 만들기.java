class Solution {
    public static void main(String[] args) {
        System.out.println(solution("99999999",3));
        solution("91",1);
    }
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        for(int i=0; i<number.length()-k; i++) {
            char max = 0;
            for(int j= idx; j<=i+k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
                if(max== '9') {
                    max = number.charAt(j);
                    idx = j + 1;
                    break;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}

//자신의 오른쪽 수보다 작으면 삭제
//오름차순 정렬 형태라면 맨 앞 삭제