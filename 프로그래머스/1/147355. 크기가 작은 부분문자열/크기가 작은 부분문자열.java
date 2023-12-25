class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pp = Long.parseLong(p);
        for(int i=0; i<=t.length()-p.length(); i++) {
                long sub = Long.parseLong(t.substring(i,i+p.length()));
            if(sub <= pp) {
                answer++;
            }
        }
        return answer;
    }
}