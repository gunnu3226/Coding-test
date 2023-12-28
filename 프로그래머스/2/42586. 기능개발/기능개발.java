import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        solution(new int[]{95,90,99,99,80,99},new int[]{1,1,1,1,1,1});
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int day = 1;
            for(int j=0; j<100;j++) {
                progresses[i] += speeds[i];
                if(progresses[i] >= 100) {
                    q.add(day);
                    break;
                }
                day++;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int num = q.poll();
            int count = 1;
            while (!q.isEmpty() && q.peek()<=num) {
                q.poll();
                count++;
            }
            list.add(count);

        }
        return list.stream().mapToInt(i->i).toArray();
    }
}

//1.각 프로그레스에 각 스피드를 더하고 맨 앞수가 100이 된 순간 날짜를 배열을 만들어 저장한다.
//2.만든 배열을 순서대로 큐에 넣는다.
//3.큐에서 하나를 제거하면서 값을 저정하고 다음 peek값이 저장된 값보다 크면 pop 하면서 count 증가
// 를 반복문 하고 날짜 종료시 리스트에 저장.

//4.큐가 빌때까지 반복