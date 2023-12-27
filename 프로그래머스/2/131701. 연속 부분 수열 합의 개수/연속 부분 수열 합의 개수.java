class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] duplication = new int[elements.length*2];
        for(int i=0; i<duplication.length; i++) {
            duplication[i] = elements[i%elements.length];
        }
        
        boolean[] check = new boolean[10000001];
        for(int i=0; i< elements.length; i++) {
            int sum = 0;
            for(int j=0; j<elements.length; j++) {
                sum += duplication[i+j];
                if(!check[sum]) {
                    answer++;
                    check[sum] = true;
                }
            }
        }
        return answer;
    }
}