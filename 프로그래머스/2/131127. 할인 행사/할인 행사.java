//1. 맵을 만들어서 원하는 제품을 키, 인덱스를 value값으로 저장.
//2. discount를 처음부터 10개씩 돌면서, 맵에서 제품이를을 호출하고 number[value]--
//3. 10개를 다 돌았을 때, 모든 value가 0이면 answer++

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        solution(new String[]{"banana", "apple", "rice", "pork", "pot"},new int[]{3, 2, 2, 2, 1},new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});;
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length;i++) {
            map.put(want[i], i);
        }
        for(int i=0; i<=discount.length-10;i++){
            int[] duplication = new int[number.length];
            for(int k=0; k<duplication.length; k++) {
                duplication[k] = number[k];
            }
            for(int j=0; j<10; j++) {
                if(map.containsKey(discount[i+j])) {
                    duplication[map.get(discount[i+j])]--;
                }
            }
            boolean check = true;
            for(int num : duplication) {
                if(num != 0) {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}