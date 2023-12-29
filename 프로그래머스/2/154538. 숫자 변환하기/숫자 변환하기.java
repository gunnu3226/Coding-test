import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        solution(2,2,1);
    }
    public static int solution(int x, int y, int n) {
        if(x == y) return 0;
        int count = 0;
        boolean[] check = new boolean[y+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int cnt = q.poll();
                if(cnt == y) {
                    return count;
                }
                if(cnt + n <= y  && !check[cnt+n]) {
                    q.add(cnt + n);
                    check[cnt + n] = true;
                }
                if(cnt * 2 <= y&& !check[cnt*2]) {
                    q.add(cnt * 2);
                    check[cnt * 2] = true;
                }
                if(cnt * 3 <= y&& !check[cnt*3]) {
                    q.add(cnt * 3);
                    check[cnt * 3] = true;
                }
            }
            count++;
        }
        return -1;
    }
}

//while로 종료조건은 x>y이면 종료
// x == y 정답
//