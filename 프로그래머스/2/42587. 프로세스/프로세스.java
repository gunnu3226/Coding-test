import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            boolean check = false;
            int index = q.poll();

            for (int nextProcess : q) {
                if (priorities[index] < priorities[nextProcess]) {
                    check = true;
                    break;
                }
            }
            if (check) {
                q.add(index);
            } else {
                answer++;

                if (index == location) {
                    break;
                }
            }
        }
        return answer;
    }
}


//            for(int i=index+1; i< priorities.length; i++) {
//                if(priorities[index] < priorities[i]) {
//                    q.add(index);
//                    check = false;
//                    break;
//                }
//            }
//            if(check) {
//                priorities[index] = 0;
//                answer++;
//            }
//            if(index == location && check) {
//                break;
//            }
//        }
//        return answer;
//    }
//}

//1. 큐를 만든다.
//2. priorities배열의 길이만큼 index를 큐에 넣는다.
//3. 큐에서 하나를 꺼내고 꺼낸 인덱스 이후 인덱스에 꺼낸 인덱스의 값보다 큰수가 있다면,
//꺼낸 인덱스를 다시 큐에 넣는다.
//4. 큰수가 없다면, 다시 삽입하지 않고 시행 answer++;
//5. 꺼냈던 인덱스가 location과 같다면 종료