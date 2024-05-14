import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();

        Map<String,String> map = new HashMap<>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");
        map.put(">","<");

        for (int tc = 1; tc <= 10; tc++) {
            boolean check = true;
            int n = sc.nextInt();
            String[] arr = sc.next().split("");
            //n이 홀수이면 종료
            if(n%2 != 0 || map.containsKey(arr[0])) {
                check = false;
            }
            Stack<String> stack = new Stack<>();
            stack.add(arr[0]);

            for(int i=1; i<n; i++) {
                if (map.containsKey(arr[i])) {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    } else {
                        if (stack.peek().equals(map.get(arr[i]))) {
                            stack.pop();
                        } else {
                            check = false;
                            break;
                        }
                    }
                } else {
                    stack.add(arr[i]);
                }
            }
            if (stack.isEmpty() && check) {
                System.out.println("#"+tc+" 1");
            } else System.out.println("#"+tc+" 0");
        }
    }
}