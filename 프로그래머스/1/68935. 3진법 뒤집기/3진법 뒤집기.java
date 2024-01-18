class Solution {

    public static void main(String[] args) {
        solution(45);
    }
    public static int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String str2 = sb.toString();
        answer = Integer.parseInt(sb.toString(),3);
        return answer;
    }
}