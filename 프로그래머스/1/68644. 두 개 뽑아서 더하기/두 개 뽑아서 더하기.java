import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {
        boolean[] check = new boolean[200];
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!check[numbers[i] + numbers[j]]) {
                    check[numbers[i] + numbers[j]] = true;
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i< list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}