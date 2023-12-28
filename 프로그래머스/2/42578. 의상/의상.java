import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;

        for(int i =0; i<clothes.length;i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1],idx);
                idx++;
            }
        }
        int[] count = new int[map.size()];
        for(int i =0; i<clothes.length;i++) {
            count[map.get(clothes[i][1])]++;
        }
        for(int i=0; i<count.length;i++) {
            answer *= (count[i]+1);
        }
        return answer-1;
    }
}

//1.맵을 만들어서 의상 종류별로 인덱스를 저장한다.
//2.맵에 있는 인덱스만큼 의상 종류를 저장할 배열을 만든다.
//3.clothes를 돌면서 맵에 키가 있으면 카운트를 바로 올리고,
// 없으면 맵에 먼저 추가하고 카운트를 올린다.