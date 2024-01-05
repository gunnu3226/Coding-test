import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public static int[] solution(String s) {
        int[] answer = {};
        List<String> list = new LinkedList<>();
        String str = s.substring(2,s.length()-2).replace("},{","-");
        String[] strs = str.split("-");
        Arrays.sort(strs, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        int idx = 0;
        for (String string : strs) {
            String[] arr2 = string.split(",");
            for (int i = 0; i < arr2.length; i++) {
                if (!list.contains(arr2[i])) {
                    list.add(arr2[i]);
                }
            }
        }
        return list.stream().mapToInt(Integer::parseInt).toArray();
    }
}


//개수가 1개인 집합부터 순서대로 튜플의 원소이다.
//개수가 1개인 집합은 튜블의 첫번째 원소
//개수가 2개인 집합에서 첫번째 원소를 제외한 하나가 두번째 원소
//개수가 3개인 집합에서 2개인 집합을 뺀 원소가 세번째 원소
//이런 형식으로 튜플을 구할 수 있다.
